package effectivejava.chapter4.item24;

// 静态成员类优于非静态成员类

// 如果内嵌类的实例需要用到外围类实例的属性或方法的时候，使用非静态成员类。
public class n2_Outter {

    private int outer = 10;

    private class Inner {

        private void run() {
            System.out.println(n2_Outter.this.outer);
        }

    }

    public static void main(String[] args) {
        new n2_Outter().new Inner().run();
    }

}
