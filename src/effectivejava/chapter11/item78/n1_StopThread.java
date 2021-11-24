package effectivejava.chapter11.item78;

import java.util.concurrent.*;

// 对共享可变数据的同步访问
// Broken! - How long would you expect this program to run?  (Page 312)
public class n1_StopThread {
    private static boolean stopRequested;

    // 在缺乏同步的情况下，无法保证后台线程何时（如果有的话）看到主线程所做的 stopRequested 值的更改
    // 左边的代码会被JVM优化成右边
    // while (!stopRequested)        if (!stopRequested)
    //    i++;                          while (true)
    //                                     i++;
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested)
                i++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}