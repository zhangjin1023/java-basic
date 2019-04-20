package dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用ThreadLocal实现线程独享.相比方法独享的局部变量来说，能减少许多对象的创建。
 * 如果对性能要求比较高的情况下，一般推荐使用这种方法。
 *
 * @author zhang_jin[zhang_jin@suixingpay.com]
 */
public class DateUtil4 {

    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String formateDate(Date date) {
        return threadLocal.get().format(date);
    }

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

}
