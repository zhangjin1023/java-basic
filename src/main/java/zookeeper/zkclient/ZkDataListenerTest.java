package zookeeper.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * All rights Reserved, Designed By XXXCompany.
 * 监听节点内容的变更或删除节点内容的事件
 *
 * @author: 张锦
 * @date: 2019/5/12 12:34
 * @Copyright ©2019 XXXCompany. All rights reserved.
 * 注意：本内容仅限于XXX有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class ZkDataListenerTest {
    public static void main(String[] args) {
        // 建立会话
        ZkClient zkClient = new ZkClient("localhost:2181");
        zkClient.setZkSerializer(new MyZkSerializer());
        System.out.println("zookeeper session established");

        // 创建节点
        String path = "/zk-book/zk-data-listener";
        if (zkClient.exists(path)) {
            zkClient.deleteRecursive(path);
        }

        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("Node " + s + " changed,new Data:" + o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("Node " + s + " deleted.");
            }
        });

        zkClient.createPersistent(path, "123456");
        System.out.println(zkClient.readData(path).toString());
        zkClient.writeData(path, "test");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zkClient.delete(path);
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
