package spring;

import org.springframework.stereotype.Component;

@Component
public class TypeA implements IType {

    @Override
    public int type() {
        return 0;
    }
}
