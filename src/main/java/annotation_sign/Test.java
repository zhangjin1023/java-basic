/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年10月26日 下午11:53:35
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package annotation_sign;

/**
 * TODO
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年10月26日 下午11:53:35
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2018年10月26日 下午11:53:35
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Header header = new Header();
        header.setMsgType("hvps.711.01.1");
        header.setSender(" aaa   ");// 测试前后带空格
        // header.setSendTime("20180605");//测试字段为null
        header.setRmk("你好");// 非签名要素
        SendInf sendInf = new SendInf();
        sendInf.setSendOrgCd("Z91100000171");
        header.setSendInf(sendInf);
        LoginReq loginReq = new LoginReq();
        loginReq.setHeader(header);
        loginReq.setMsgId("123456");
        StringBuilder signBuilder = new StringBuilder();
        SignProcessor.getSign(signBuilder, loginReq, LoginReq.class);
        System.out.println(signBuilder.toString());
    }

}
