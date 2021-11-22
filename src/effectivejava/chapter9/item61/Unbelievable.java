package effectivejava.chapter9.item61;

// 只要有选择，就应该优先使用基本类型，而不是包装类型
// 首先，基本类型只有它们的值，而包装类型具有与其值不同的标识。将 == 操作符应用于包装类型几乎都是错误的
// 第二，基本类型只有全功能值，而每个包装类型除了对应的基本类型的所有功能值外，还有一个非功能值，即 null\
// 最后，基本类型比包装类型更节省时间和空间
// What does this program do? - Page 274
public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {
        if (i == 42)
            System.out.println("Unbelievable");
    }
}