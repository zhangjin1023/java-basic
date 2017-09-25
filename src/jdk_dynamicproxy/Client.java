/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: zhang_jin[zhang_jin@suixingpay.com] 
 * @date: 2017年9月24日 下午1:12:50   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package jdk_dynamicproxy;

/**  
 * TODO
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年9月24日 下午1:12:50
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年9月24日 下午1:12:50
 */
public class Client {
    public static void main(String[] args) {
        Moveable car = new Car();
        MyInvovationHandler carHandler =new MyInvovationHandler(car);
        Moveable proxyInstance = carHandler.getProxyInstance();
        proxyInstance.move();
        
        Moveable plane = new Plane();
        MyInvovationHandler planeHandler =new MyInvovationHandler(plane);
        Moveable proxyInstance2 = planeHandler.getProxyInstance();
        proxyInstance2.move();
    }

}
