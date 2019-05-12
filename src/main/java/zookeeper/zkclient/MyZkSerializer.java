package zookeeper.zkclient;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.io.UnsupportedEncodingException;

/**
 * All rights Reserved, Designed By XXXCompany.
 * 自定义序列化和反序列化的工具，默认的会出现乱码
 *
 * @author: 张锦
 * @date: 2019/5/12 12:48
 * @Copyright ©2019 XXXCompany. All rights reserved.
 * 注意：本内容仅限于XXX有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class MyZkSerializer implements ZkSerializer {
    /**
     * 序列化，将对象转化为字节数组
     *
     * @return byte[]
     * @Author zhang_jin@XXXCompany.com
     * @Date 12:49 2019/5/12
     * @Param [o]
     **/
    @Override
    public byte[] serialize(Object obj) throws ZkMarshallingError {
        try {
            return String.valueOf(obj).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化，将字节数组转化为UTF_8字符串
     *
     * @return java.lang.Object
     * @Author zhang_jin@XXXCompany.com
     * @Date 12:49 2019/5/12
     * @Param [bytes]
     **/
    @Override
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
