package effectivejava.chapter5.item32;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

// Subtle heap pollution (Pages 147-8)
public class n3_PickTwo {
    // UNSAFE - Exposes a reference to its generic parameter array!
    // 这个数组的类型由传递给方法的参数的编译时类型决定
    // 编译器可能没有足够的信息来做出准确的决定（如被 pickTwo 调用时，无法识别只能分配 Object[] ）
    static <T> T[] toArray(T... args) {
        T[] res = (T[]) new Object[]{args[0], args[1]};
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }

    public static void main(String[] args) {
        toArray("Good", "Fast");    // toArray return String[]
        String[] attributes = pickTwo("Good", "Fast", "Cheap");  // toArray return Object[] // Object[] 不能强转 String[]，故运行时报错
        System.out.println(Arrays.toString(attributes));
    }
}
