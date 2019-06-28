package spring;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TypeFactory implements InitializingBean {
    private static Map<Integer, IType> TypeBeanContainer = new HashMap<>();

    public static IType getBeanByType(int type) {
        return TypeBeanContainer.get(type);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map beansOfType = SpringContextHelper.getBeansOfType(IType.class);
        for (Object obj : beansOfType.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            IType value = (IType) entry.getValue();
            TypeBeanContainer.put(value.type(), value);
        }
    }
}
