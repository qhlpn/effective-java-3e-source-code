package effectivejava.chapter4.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 尽量减少类和成员的可访问性
// 在仔细设计了类的公共 API 之后，你应该本能的使所有成员都是私有的。
// 对于公共类（会被继承的类）的成员来说，当访问级别从包级私有变为保护时，可访问性会有很大的提高。保护成员是类导出 API 的一部分，必须永远支持
public class Main {

    // 你可以通过公共静态 final 字段公开常量
    // 请注意，非零长度的数组总是可变的，因此对于类来说，拥有一个公共静态 final 数组字段或返回该字段的访问器是错误的
    // public static final Object[] VALUES = {};

    // 解决方法
    // 你可以将公共数组设置为私有，并添加一个 公共不可变 List：
    private static final Object[] PRIVATE_VALUES = {};
    public static final List<Object> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

   // 或者，你可以将数组设置为私有，并添加一个返回私有数组副本的公共方法：
   public static final Object[] values() {
       return PRIVATE_VALUES.clone();
   }


}
