package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;


public class CuratorCRUDTest {
    public static void main(String[] args) throws Exception {
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
//        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", 5000, 3000, retry);
//        client.start();
//        try {
//            Thread.sleep(Integer.MAX_VALUE);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // 使用fluent 风格的API创建会话
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181").sessionTimeoutMs(5000).retryPolicy(retry).build();
        client.start();

        // 创建节点
        String path = "/zk-book/curator";
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path, "init".getBytes());

        // 读取数据
        Stat stat = new Stat();
        System.out.println(new String(client.getData().storingStatIn(stat).forPath(path)));

        // 带版本号的数据更新
        int newVersion = client.setData().withVersion(stat.getVersion()).forPath(path, "a".getBytes()).getVersion();
        System.out.println("Success set Node for : " + path + ",new version : " + newVersion);

        try {
            client.setData().withVersion(stat.getVersion()).forPath(path, "a".getBytes()).getVersion();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 带版本号的删除
        try {
            client.delete().deletingChildrenIfNeeded().withVersion(stat.getVersion()).forPath(path);
        } catch (Exception e) {
            System.out.println("fail deleted node : " + path + "due to " + e.getMessage());
        }

        client.delete().deletingChildrenIfNeeded().withVersion(newVersion).forPath(path);
        System.out.println("Success deleted node : " + path);


    }
}
