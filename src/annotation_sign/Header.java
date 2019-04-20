/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年10月26日 下午11:47:27
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package annotation_sign;

/**
 * TODO
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年10月26日 下午11:47:27
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2018年10月26日 下午11:47:27
 */
public class Header {
    private String MsgType;
    private String Sender;
    private String SendTime;
    private SendInf SendInf;
    @SignExclude
    private String Rmk;

    public SendInf getSendInf() {
        return SendInf;
    }

    public void setSendInf(SendInf sendInf) {
        SendInf = sendInf;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getSendTime() {
        return SendTime;
    }

    public void setSendTime(String sendTime) {
        SendTime = sendTime;
    }

    public String getRmk() {
        return Rmk;
    }

    public void setRmk(String rmk) {
        Rmk = rmk;
    }

}
