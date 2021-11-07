package effectivejava.chapter5.item30;

import java.util.*;

// Using a recursive type bound to express mutual comparability (Pages 137-8)
// 递归类型限定
public class n2_RecursiveTypeBound {
    // Returns max value in a collection - uses recursive type bound
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty collection");

        E result = null;
        for (E e : c)
            // <E extends Comparable<E>>  -> 编译器  E e 才能显示 compareTo(E) 方法
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }

    public static void main(String[] args) {
        List<String> argList = Arrays.asList("1", "2", "3", "4");
        String s = max(argList);
    }
}