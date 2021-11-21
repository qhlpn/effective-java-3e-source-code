package effectivejava.chapter8.item52;

import java.util.*;
import java.math.*;

// 小心地使用重载
// 1. 重载方法的选择是静态的，在编译时就决定了要调用哪个重载
// 2. 应该避免混淆重载的用法
//    - 安全、保守的策略是永远不导出具有相同数量参数的两个重载，因为 你总是可以为方法提供不同的名称，而不是重载它们
//    - 至少应该避免同一组参数只需经过类型转换就可以被传递给不同的重载方法
// Broken! - What does this program print?  (Page 238)
public class n1_CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}
