package zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;

/**
 * All rights Reserved, Designed By XXXCompany.
 * 监听节点的子节点变更，以及节点自身的创建和删除
 *
 * @author: 张锦
 * @date: 2019/5/12 12:01
 * @Copyright ©2019 XXXCompany. All rights reserved.
 * 注意：本内容仅限于XXX有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class ZkListenerTest {
    public static void main(String[] args) {
        // 建立会话
        ZkClient zkClient = new ZkClient("localhost:2181");
        System.out.println("zookeeper session established");


        // 创建节点
        String path = "/zk-book/zk-listener1";
        if (zkClient.exists(path)) {
            zkClient.deleteRecursive(path);
        }

        zkClient.subscribeChildChanges(path, (s, list) -> System.out.println(s + " 's child changed,currentChildren:" + list));

        zkClient.createPersistent(path);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(zkClient.getChildren(path));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zkClient.createPersistent(path + "cl");
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
        // 后面可在cli命令行进行操作，增加和删除节点。上面注册的监听器可以实时感知到变化

    }
}
