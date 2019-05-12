package dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 采用static静态变量:不是线程安全的。
 * ==>解决方案：同步锁
 * 　说明：当线程较多时，当一个线程调用该方法时，其他想要调用此方法的线程就要block，
 * 多线程并发量大的时候会对性能有一定的影响。
 *
 * @author zhang_jin[zhang_jin@XXXCompany.com]
 */
public class DateUtil3 {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formateDate(Date date) {
        synchronized (sdf) {
            return sdf.format(date);
        }
    }

    public static Date parse(String dateStr) throws ParseException {
        synchronized (sdf) {
            return sdf.parse(dateStr);
        }
    }

}
