package JVM;

public class InnerClassTest {
    public InnerClassTest(int o) {
        System.out.println(o);
    }
    public static class testInner {
        //构造器还是不能静态修饰一一这也是为什么调用静态内部类时还是要new构造方法
        public testInner(int b) {
            System.out.println(b);
        }
        int i;
        static int j = 5;
    }

    public class testOutter {
        public testOutter(int c) {
            System.out.println(c);
        }
        //非静态不能有静态字段
    }

    public static void main(String[] args) {
        testInner ti = new testInner(4);
        //非静态需要同时new内外两个类
        testOutter to = new InnerClassTest(5).new testOutter(6);
    }
}
