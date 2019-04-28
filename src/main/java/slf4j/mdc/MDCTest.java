package slf4j.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Map;
import java.util.UUID;

/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: 张锦
 * @date: 2019/4/29 0:02
 * @Copyright ©2019 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class MDCTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MDCTest.class);

    public static void main(String[] args) {
        MDC.put("tradeId", UUID.randomUUID().toString());
        LOGGER.info("你好");
        // 默认情况下，子线程是不会携带父线程的MDC变量的,需要手动处理
        Thread thread = new Thread(() -> LOGGER.info("*****子线程日志*****"));
        thread.start();

        // 此处MDC.getCopyOfContextMap()获取的是原MDC变量的拷贝，参看源码可以知道是新new了一个HashMap容纳父线程的MDC信息
        // 所以传递给子线程后，即使子线程修改了MDC的值，也不会影响父线程。
        Thread thread2 = new MDCSubThread(MDC.getCopyOfContextMap());
        thread2.start();

        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            LOGGER.error("InterruptedException", e);
        }

        LOGGER.info("hello");
    }

    static class MDCSubThread extends Thread {
        Map<String, String> copyOfContextMap;

        public MDCSubThread(Map<String, String> copyOfContextMap) {
            this.copyOfContextMap = copyOfContextMap;
        }

        @Override
        public void run() {
            MDC.setContextMap(copyOfContextMap);
            LOGGER.info("*****子线程日志2*****你好");
            MDC.clear();
            LOGGER.info("*****子线程日志2*****hello");
        }
    }
}
