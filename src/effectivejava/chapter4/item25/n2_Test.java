package effectivejava.chapter4.item25;

// Static member classes instead of multiple top-level classes (Page 116)
// 如果你想将多个顶层类放到一个源文件中，请考虑使用静态成员类（Item-24）作为将类分割为单独的源文件的替代方法
public class n2_Test {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }

    private static class Utensil {
        static final String NAME = "pan";
    }

    private static class Dessert {
        static final String NAME = "cake";
    }
}
