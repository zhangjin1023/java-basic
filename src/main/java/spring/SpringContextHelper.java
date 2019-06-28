package spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SpringContextHelper implements ApplicationContextAware {

    @SuppressWarnings("unused")
	private static Environment environment;

    private static ApplicationContext context;

    // 提供一个接口，获取容器中的Bean实例，根据名称获取
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static Map getBeansOfType(Class type) {
        return context.getBeansOfType(type);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringContextHelper.context = context;
    }

}
