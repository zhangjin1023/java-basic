/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年10月26日 下午11:46:42
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package annotation_sign;

/**
 * TODO
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2018年10月26日 下午11:46:42
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2018年10月26日 下午11:46:42
 */
public class LoginReq {
    private String MsgId;
    private Header Header;

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        this.MsgId = msgId;
    }

    public Header getHeader() {
        return Header;
    }

    public void setHeader(Header header) {
        this.Header = header;
    }

}
