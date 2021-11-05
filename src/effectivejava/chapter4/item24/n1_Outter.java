package effectivejava.chapter4.item24;

// 静态成员类优于非静态成员类

// 如果声明的成员类不需要访问外部的实例，那么应始终在声明中添加 static 修饰符，使其成为静态的而不是非静态的成员类
// 如果省略这个修饰符，每个实例都有一个隐藏的对其外部实例的额外引用
public class n1_Outter {

    private static class Inner {

    }

    public static void main(String[] args) {
        new Inner();
    }

}
