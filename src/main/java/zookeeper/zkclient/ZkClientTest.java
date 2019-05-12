package zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * All rights Reserved, Designed By XXXCompany.
 *
 * @author: 张锦
 * @date: 2019/5/12 11:28
 * @Copyright ©2019 XXXCompany. All rights reserved.
 * 注意：本内容仅限于XXX有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class ZkClientTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 建立会话
        ZkClient zkClient = new ZkClient("localhost:2181");
        System.out.println("zookeeper session established");

        // 创建节点
        String path = "/zk-book/zkCli/test";
        zkClient.createPersistent(path, true);

        // 删除节点
        zkClient.deleteRecursive("/zk-book/zkCli");

        // 读取数据
        List<String> children = zkClient.getChildren("/zk-book");
        System.out.println(children);

        // 更新数据
        zkClient.writeData("/zk-book/zkClient", 123);

        // 检测节点是否存在
        boolean exists = zkClient.exists("/zk-book/zkClient");
        System.out.println(exists);
    }
}
