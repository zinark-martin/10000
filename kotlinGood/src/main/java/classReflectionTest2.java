import java.lang.reflect.InvocationTargetException;
import	java.lang.reflect.Method;

import	java.time.LocalTime;

public class classReflectionTest2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        String original = "Hello World!";
        Method method = String.class.getDeclaredMethod("substring", int.class);
        String made = (String) method.invoke(original,6);

        Method method2 = String.class.getDeclaredMethod("substring", int.class, int.class);
        String made2 = (String) method2.invoke(made,2,3);

        System.out.println(Integer.parseInt("123"));//This is a static method
        Method method3 = Integer.class.getDeclaredMethod("parseInt", String.class);
        Integer parsed = (Integer) method3.invoke(null,"23452");//静态方法无参 第一个参数为null
        System.out.println(parsed);
        test te1 = new test(123);
        test te = test.class.getDeclaredConstructor(int.class).newInstance(123);

        Class cls1 = Class.forName("java.lang.String");
        Class cls2 = String.class;
        Class cls3 = "".getClass();
        //以上三种是一个Class实例, 因为JVM对每个加载的Class只创建一个Class实例表示它的类型
        boolean is1 = cls1 == cls2;
        boolean is2 = cls2 == cls3;
        System.out.println(is2);
        System.out.println(is1);
        Class cls4 = Integer.valueOf(9).getClass();
        Class cls5 = cls4.getSuperclass();
        Class cls6 = cls5.getSuperclass();
        System.out.println(cls4);//Integer
        System.out.println(cls5);//Number
        System.out.println(cls6);//Object

        Class [] interfaces = Integer.class.getInterfaces();
        for (Class it: interfaces) {
            System.out.println(it + " " + LocalTime.now());
        }
    }
}
class test {
    public test(int in) {
        System.out.println(in);
    }
    interface inter {}
}
