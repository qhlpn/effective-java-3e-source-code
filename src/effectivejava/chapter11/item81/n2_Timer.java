package effectivejava.chapter11.item81;

import java.util.concurrent.*;


// 同步器是允许线程彼此等待的对象，允许它们协调各自的活动。
// 最常用的同步器是 CountDownLatch 和 Semaphore。
// 较不常用的是 CyclicBarrier 和 Exchanger。
// 最强大的同步器是 Phaser。

// Simple framework for timing concurrent execution 327
public class n2_Timer {
    private n2_Timer() {
    } // Noninstantiable

    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // Tell timer we're ready
                try {
                    start.await(); // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();  // Tell timer we're done
                }
            });
        }

        ready.await();     // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown(); // And they're off!
        done.await();      // Wait for all workers to finish

        return System.nanoTime() - startNanos;
        // 对于间隔计时，始终使用 System.nanoTime 而不是 System.currentTimeMillis。 System.nanoTime 不仅更准确，而且更精确，而且不受系统实时时钟调整的影响。

    }
}
