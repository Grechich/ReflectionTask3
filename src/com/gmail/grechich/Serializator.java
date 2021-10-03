package com.gmail.grechich;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Serializator {

    public static String serialize(Object o) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        final Class<?> cls = Simple.class;
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Save.class))
                continue;
            field.setAccessible(true);
            sb.append(field.getName() + "=");
            if (field.getType() == int.class) {
                sb.append(field.getInt(o));
            } else if (field.getType() == String.class) {
                sb.append((String) field.get(o));
            } else {
                sb.append(field.get(o));
            }
            sb.append(";");
        }
        return sb.toString();
    }

    public static <T> T deserialize(String str, Class<T> cls) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        T res = cls.getConstructor().newInstance();
        String[] fields = str.split(";");
        for (String s : fields) {
            String[] nameValue = s.split("=");
            String name = nameValue[0];
            String value = nameValue[1];

            Field f = res.getClass().getDeclaredField(name);
            if (!f.isAnnotationPresent(Save.class))
                continue;

            f.setAccessible(true);

            if (f.getType() == int.class)
                f.setInt(res, Integer.parseInt(value));

            if (f.getType() == String.class)
                f.set(res, value);
        }
        return res;
    }
}
