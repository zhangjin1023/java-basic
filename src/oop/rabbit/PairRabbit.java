package oop.rabbit;

/**
 * 面向对象思想解决兔子问题（斐波那契数列）
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年9月25日 下午8:27:42
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年9月25日 下午8:27:42
 */
public class PairRabbit {
    // 月龄
    private int month;

    /**
     * 构造器
     */
    public PairRabbit(int month) {
        this.month = month;
    }

    // 产小兔子的方法
    public PairRabbit born() {
        return new PairRabbit(1);
    }

    // 兔子长大的方法
    public void growUp() {
        this.month++;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

}
