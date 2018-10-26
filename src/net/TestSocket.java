/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: zhang_jin[zhang_jin@suixingpay.com] 
 * @date: 2018年4月24日 下午7:57:26   
 * @Copyright ©2018 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * TODO
 * 
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年4月24日 下午7:57:26
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2018年4月24日 下午7:57:26
 */
public class TestSocket {
    public static void main(String[] args) {
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress("ipay.cmbc.com.cn", 9012);
        long startTime = System.currentTimeMillis();
        try {
            socket.connect(socketAddress,3*1000);
        } catch (IOException e) {
            System.out.println(System.currentTimeMillis()-startTime);
            e.printStackTrace();
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

}
