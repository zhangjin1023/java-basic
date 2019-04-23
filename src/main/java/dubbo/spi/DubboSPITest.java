package dubbo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: 张锦
 * @date: 2019/4/21 13:49
 * @Copyright ©2019 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
public class DubboSPITest {

    @Test
    public void sayHello() {
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        ExtensionLoader<Robot> extensionLoader2 = ExtensionLoader.getExtensionLoader(Robot.class);

        // ExtensionLoader是每一种Class类型对应唯一的实例
        System.out.println(extensionLoader == extensionLoader2);

        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();

        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
