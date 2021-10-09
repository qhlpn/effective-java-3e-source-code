package effectivejava.chapter2.item4;

// 用私有构造函数实现不可实例化
public class UtilityClass {

    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }

    // Remainder omitted
}
