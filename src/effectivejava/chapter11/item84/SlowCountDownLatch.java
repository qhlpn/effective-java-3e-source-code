package effectivejava.chapter11.item84;

// 不要依赖线程调度器来判断程序的正确性
// 编写健壮、响应快、可移植程序的最佳方法是确保可运行线程的平均数量不显著大于处理器的数量
// 这使得线程调度器几乎没有选择：它只运行可运行线程，直到它们不再可运行为止。即使在完全不同的线程调度策略下，程序的行为也没有太大的变化。

// 当面对一个几乎不能工作的程序时，而原因是由于某些线程相对于其他线程没有获得足够的 CPU 时间，
// 那么 通过 Thread.yield / 调整线程优先级 来「修复」程序，你也许能勉强让程序运行起来，但它是不可移植的
// 更好的做法是重构应用程序，以减少并发运行线程的数量。

// 保持可运行线程数量低的主要技术是让每个线程做一些有用的工作，然后等待更多的工作。如果线程没有做有用的工作，它们就不应该运行。
// 对于 Executor 框架，这意味着适当调整线程池的大小，并保持任务短小（但不要太短），否则分派开销依然会损害性能。

// Awful CountDownLatch implementation - busy-waits incessantly!  - Pages 336-7
public class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count) {
        if (count < 0)
            throw new IllegalArgumentException(count + " < 0");
        this.count = count;
    }

    public void await() {
        // 循环检查状态变化大大增加了处理器的负载，还影响其他线程获取处理器进行工作
        while (true) {
            synchronized (this) {
                if (count == 0)
                    return;
            }
        }
    }

    public synchronized void countDown() {
        if (count != 0)
            count--;
    }
}
