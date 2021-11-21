package effectivejava.chapter8.item53;

import java.util.stream.IntStream;

// 小心地使用可变参数
// Sample uses of varargs (Pages 245-6)
public class Varargs {
    // Simple use of varargs (Page 245)
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }

    // The WRONG way to use varargs to pass one or more arguments! (Page 245)
    // 这个解决方案有几个问题。
    // 最严重的情况是，如果客户端不带参数调用此方法，那么它将在运行时而不是编译时失败。
    // 另一个问题是它不美观。必须包含对 args 的显式有效性检查，并且不能使用 for-each 循环，除非将 min 初始化为 Integer.MAX_VALUE，也很不美观
    static int min(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Too few arguments");
        int min = args[0];
        for (int i = 1; i < args.length; i++)
            if (args[i] < min)
                min = args[i];
        return min;
    }

    // The right way to use varargs to pass one or more arguments (Page 246)
    // 幸运的是，有一种更好的方法可以达到预期的效果。声明方法获取两个参数，一个指定类型的常规参数和一个该类型的可变参数
    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }


    // 在性能关键的情况下使用可变参数时要小心。每次调用可变参数方法都会导致数组分配和初始化。
    // 如果你已经从经验上确定你负担不起这个成本，但是你仍需要可变参数的灵活性，那么有一种模式可以让你鱼与熊掌兼得。
    // 假设你已经确定对方法 95% 的调用只需要三个或更少的参数。可以声明该方法的 5 个重载，每个重载 0 到 3 个普通参数，当参数数量超过 3 个时引入可变参数：
    // public void foo() { }
    // public void foo(int a1) { }
    // public void foo(int a1, int a2) { }
    // public void foo(int a1, int a2, int a3) { }
    // public void foo(int a1, int a2, int a3, int... rest) { }
}
