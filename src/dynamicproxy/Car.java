/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: zhang_jin[zhang_jin@suixingpay.com] 
 * @date: 2017年9月24日 下午1:01:52   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package dynamicproxy;

/**  
 * TODO
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年9月24日 下午1:01:52
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年9月24日 下午1:01:52
 */
public class Car implements Moveable {

    /**      
     * TODO 
     * @see dynamicproxy.Moveable#move()
     */
    @Override
    public void move() {
        System.out.println("汽车 嘟嘟嘟 开跑了");

    }

}
