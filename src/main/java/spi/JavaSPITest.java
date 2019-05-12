package spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * All rights Reserved, Designed By XXXCompany.
 *
 * @author: 张锦
 * @date: 2019/4/21 13:49
 * @Copyright ©2019 XXXCompany. All rights reserved.
 * 注意：本内容仅限于XXX有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class JavaSPITest {

    @Test
    public void sayHello() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
