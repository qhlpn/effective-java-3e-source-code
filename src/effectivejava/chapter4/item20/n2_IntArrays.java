package effectivejava.chapter4.item20;

import java.util.*;

public class n2_IntArrays {
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        // 抽象骨架（无论是单独的抽象类，还是仅仅由接口上的默认方法组成）可以使程序员非常容易地提供他们自己的接口实现
        // 例如，这里有一个静态工厂方法，它在 AbstractList（抽象骨架） 上包含一个完整的、功能完整的 List 实现
        return new AbstractList<>() {
            @Override
            public Integer get(int i) {
                return a[i];  // Autoboxing (Item 6)
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;     // Auto-unboxing
                return oldVal;  // Autoboxing
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        List<Integer> list = intArrayAsList(a);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
