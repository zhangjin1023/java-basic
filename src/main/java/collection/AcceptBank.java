/**
 * All rights Reserved, Designed By XXXCompany.
 *
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2018年11月20日 下午11:04:57
 * @Copyright ©2018 XXXCompany. All rights reserved.
 * 注意：本内容仅限于XXX有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package collection;

import java.util.List;

/**
 * 通道支持的一级行别
 *
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2018年11月20日 下午11:04:57
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@XXXCompany.com]/2018年11月20日 下午11:04:57
 */
public class AcceptBank {
    private String bankCd;// 行别编码
    private String selectAll;// 是否全选
    private List<String> secBank;// 二级行别

    public AcceptBank(String bankCd, String selectAll) {
        super();
        this.bankCd = bankCd;
        this.selectAll = selectAll;
    }

    public AcceptBank(String bankCd, String selectAll, List<String> secBank) {
        super();
        this.bankCd = bankCd;
        this.selectAll = selectAll;
        this.secBank = secBank;
    }

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String bankCd) {
        this.bankCd = bankCd;
    }

    public String getSelectAll() {
        return selectAll;
    }

    public void setSelectAll(String selectAll) {
        this.selectAll = selectAll;
    }

    public List<String> getSecBank() {
        return secBank;
    }

    public void setSecBank(List<String> secBank) {
        this.secBank = secBank;
    }

    @Override
    public String toString() {
        return "AcceptBank [bankCd=" + bankCd + ", selectAll=" + selectAll + ", secBank=" + secBank + "]";
    }

}
