package effectivejava.chapter2.item8;

import java.lang.ref.Cleaner;

// 避免使用 终结方法 和 清除方法 （无法保证执行）
// Object.finalize(): GC 前执行
// java.lang.ref.Cleaner: 在对象无法访问时释放资源

// 推荐 try-with-resources 之 AutoCloseable  手动 close()

public class n1_Room implements AutoCloseable {

    // 资源
    private final State state;

    // 清除器
    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;

    public n1_Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    // Resource that requires cleaning. Must not refer to Room!
    private static class State implements Runnable {
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }


        // 触发 run 方法有两种情形：
        // 1. 手动调用 close 方法，进而调用 run 方法
        // 2. GC时 还没手动调用 close 方法，则自动 执行 run 方法（不保证）
        @Override
        public void run() {
            System.out.println("Cleaning room: " + System.currentTimeMillis());
            numJunkPiles = 0;
        }
    }

    @Override
    public void close() {
        cleanable.clean();
        System.out.println("close: " + System.currentTimeMillis());
    }

}
