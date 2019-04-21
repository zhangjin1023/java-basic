package annotation_sign;

import org.jsoup.helper.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SignProcessor {
    public static void getSign(StringBuilder signBuilder, Object obj, Class<?> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (!field.isAnnotationPresent(SignExclude.class)) {
                if (field.getType() == String.class) {
                    String getMethodName = "get" + field.getName();// 因为属性都是大写字母开头，不需要修改首字母为大写了
                    Method getMethod = clazz.getMethod(getMethodName, new Class[]{});
                    // 调用getter方法获取原对象的属性值(object为原对象)
                    String value = (String) getMethod.invoke(obj, new Object[]{});
                    if (!StringUtil.isBlank(value)) {
                        signBuilder.append(value.trim()).append("|");
                    }

                } else {
                    Object subObject = field.get(obj);
                    if (subObject != null) {
                        getSign(signBuilder, subObject, field.getType());
                    }
                }
            }
        }

    }

}
