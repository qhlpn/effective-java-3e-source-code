package effectivejava.chapter5.item31;

import java.util.*;

// Using a recursive type bound with wildcards (Page 143)
public class n4_RecursiveTypeBound {

    // 递归类型限定
    // max 生产者，返回 E, 故 List<? extends E>
    // Comparable 是消费者，拿本体去比较， 故 Comparable<? super E>
    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("Empty list");

        E result = null;
        for (E e : list)
            if (result == null || e.compareTo(result) > 0)
                result = e;

        return result;
    }

    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);
        String s = max(argList);
    }
}