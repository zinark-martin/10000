//继承测试


class Constructor(val a: Int, var b: Int) {
    val c: Int = 4
    //次级构造不可以val或者var
    constructor(a: String) : this(2, 3)
    constructor(a: Int) : this(a.toString()) {
        //次级构造不会有字段(成员变量)
        val s: String = "yes"
        var t: String = "ok"
    }
    //可以委托另一个次构造, 后者必须委托自主构造器(简介委托主构造)
    constructor(b: Char) : this(":123")
    init {
        println("init 1")
    }
    init {
        println("init 2")
    }
    //首先会按顺序执行类中init代码块，然后再执行构造方法里代码
    //init代码块相当于主构造中的代码, 故初始化时就会执行
    //    public Constructor(int a) {
    //        this.a = a;
    //        String var2 = "init 1";
    //        boolean var3 = false;
    //        System.out.println(var2);
    //        var2 = "init 2";
    //        var3 = false;
    //        System.out.println(var2);
    //    }
    companion object {
        val a = "123".also { println("静态伴生") }
    }
    //而伴生对象就是来一个静态类(非内部)
    //    public static final class Companion {
    //        @NotNull
    //        public final String getA() {
    //            return Constructor.a;
    //        }
    //
    //        private Companion() {
    //        }
    //
    //        // $FF: synthetic method
    //        public Companion(DefaultConstructorMarker $constructor_marker) {
    //            this();
    //        }
    //    }
}

fun main() {
    var constructor = Constructor("123")
}
