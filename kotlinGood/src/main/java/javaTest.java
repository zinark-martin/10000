public class javaTest {
    public static void main(String[] args) {
        Integer i1 = new Integer(2);
        Integer i2 = new Integer(2);
        // new 会重新创建对象而非使用常量池,所以返回false
        System.out.println(i2 == i1);
        // Integer和String中重写了equals方法进行值比较
        System.out.println(i2.equals(i1));
    }
}
