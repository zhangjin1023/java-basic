/**
 * All rights Reserved, Designed By XXXCompany.
 *
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2017年9月24日 下午1:29:57
 * @Copyright ©2017 XXXCompany. All rights reserved.
 * 注意：本内容仅限于XXX有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package dynamicproxy.jdk;

/**
 * TODO
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2017年9月24日 下午1:29:57
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@XXXCompany.com]/2017年9月24日 下午1:29:57
 */
public class Plane implements Moveable {

    /**
     * TODO 
     * @see Moveable#move()
     */
    @Override
    public void move() {
        System.out.println("飞机轰轰轰 起飞了");
    }

}
