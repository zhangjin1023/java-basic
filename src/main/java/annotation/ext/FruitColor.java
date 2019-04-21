package annotation.ext;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果颜色注解
 *
 * @author zhang_jin[zhang_jin@suixingpay.com]
 */
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    Color fruitColor() default Color.BLUE;

    ;

    public enum Color {
        RED, BLUE, GREEN
    }

}
