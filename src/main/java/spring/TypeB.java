package spring;

import org.springframework.stereotype.Component;

@Component
public class TypeB implements IType {

    @Override
    public int type() {
        return 1;
    }
}
