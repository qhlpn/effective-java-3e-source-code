package effectivejava.chapter5.item26;

import java.util.*;

// Fails at runtime - unsafeAdd method uses a raw type (List)!  (Page 119)
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast
    }

    // 使用原始类型（没有类型参数的泛型）是合法的，但是你永远不应该这样做。如果使用原始类型，就会失去泛型的安全性和表现力
    // 无界通配符类型 List<?> 是安全的（编译期会抛异常），而原始类型则不是
    //    private static void unsafeAdd(List list, Object o) {
    //        list.add(o);
    //    }

    private static void unsafeAdd(List<String> list, Object o) {
        list.add((String)o);
    }
}

