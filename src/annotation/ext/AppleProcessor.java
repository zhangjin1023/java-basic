package annotation.ext;

import java.lang.reflect.Field;

public class AppleProcessor {
    public static void getFruitInfo(Class<?> clazz) {
        String name = "水果名称： ";
        String color = "水果颜色：";
        String provider = "水果供应商：";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                name = name + fruitName.value();
                System.out.println(name);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                color = color + fruitColor.fruitColor().toString();
                System.out.println(color);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                provider = provider + "供应商编号：" + fruitProvider.id() + ",供应商名称：" + fruitProvider.name() + ",供应商地址："
                        + fruitProvider.address();
                System.out.println(provider);
            }
        }

    }

}
