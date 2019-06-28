package spring;

import org.springframework.stereotype.Component;

@Component
public class TypeC implements IType {

    @Override
    public int type() {
        return 3;
    }
}
