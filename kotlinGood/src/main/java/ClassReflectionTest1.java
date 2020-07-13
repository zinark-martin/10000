import java.lang.reflect.Field;

import java.lang.reflect.Modifier;

public class ClassReflectionTest1 {
    public static void main(String[] args) throws  NoSuchFieldException {
        Integer n = 123;
        boolean b1 = n instanceof Integer;//true
        System.out.println(true);
        boolean b2 = n.getClass() == Integer.class;//true
        System.out.println(true);
        //boolean b3 = n.getClass() == Number.class;//false
        System.out.println(false);
        String str = "Hello";
        System.out.println("??" + n.getClass());
        Class IntClass = n.getClass();
        //IntClass.getDeclaredField("??????");
        //Integer int1 = (Integer) IntClass.getDeclaredConstructor().newInstance();
        Field f = String.class.getDeclaredField("value");
        int m = f.getModifiers();
        System.out.println(m);
        System.out.println(Modifier.isNative(m));
    }
}
