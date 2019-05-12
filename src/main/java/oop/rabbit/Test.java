/**
 * All rights Reserved, Designed By XXXCompany.
 *
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2017年9月25日 下午8:55:51
 * @Copyright ©2017 XXXCompany. All rights reserved.
 * 注意：本内容仅限于XXX有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package oop.rabbit;

/**
 * TODO
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2017年9月25日 下午8:55:51
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@XXXCompany.com]/2017年9月25日 下午8:55:51
 */
public class Test {
    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.initFarm(new PairRabbit(1));
        int rabbitCountsOfMonth = farm.getRabbitCountsOfMonth(32);
        System.out.println(rabbitCountsOfMonth);
    }

}
