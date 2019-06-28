package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class Client {
    @Test
    public void test(){
        IType beanByType = TypeFactory.getBeanByType(0);
        System.out.println(beanByType.getClass());
    }
}
