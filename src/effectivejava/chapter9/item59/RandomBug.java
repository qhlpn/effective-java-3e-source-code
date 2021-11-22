package effectivejava.chapter9.item59;

import java.util.*;

// 了解并使用库，而不是自己造轮子
// 从 Java 7 开始，就不应该再使用 Random。在大多数情况下，选择的随机数生成器现在是 ThreadLocalRandom。
//  每个程序员都应该熟悉 java.lang、java.util、java.util.concurrent 和 java.io 的基础知识及其子包

// Random number generation is hard!
// 随机方法生成的数字中有三分之二落在其范围的下半部分！
// 要编写一个 random 方法来纠正这些缺陷，你必须对伪随机数生成器、数论和 2 的补码算法有一定的了解
public class RandomBug {
    // Common but deeply flawed!
    static Random rnd = new Random();

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++)
            if (random(n) < n / 2)
                low++;
        System.out.println(low);
    }
}
