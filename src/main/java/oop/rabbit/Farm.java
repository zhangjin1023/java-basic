package oop.rabbit;

import java.util.ArrayList;
import java.util.List;

/**
 * 农场类，装兔子用
 *
 * @author: zhang_jin[zhang_jin@XXXCompany.com]
 * @date: 2017年9月25日 下午8:42:09
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@XXXCompany.com]/2017年9月25日 下午8:42:09
 */
public class Farm {
    private static final List<PairRabbit> list = new ArrayList<>();

    public void initFarm(PairRabbit p) {
        list.add(p);
    }

    public int getRabbitCountsOfMonth(int month) {
        for (int i = 1; i <= month; i++) {
            List<PairRabbit> temp = new ArrayList<>();//每个月，创建一个临时的产房
            for (PairRabbit p : list) {
                if (p.getMonth() >= 3) {
                    temp.add(p.born());//新出生的兔子待在产房
                }
            }

            list.addAll(temp);//新出生的兔子也加入到农场

            for (PairRabbit p : list) {
                p.growUp();//农场中的所有兔子增加月龄
            }
        }
        return list.size();
    }

}
