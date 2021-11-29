package effectivejava.chapter11.item83;

// 小心地使用延迟初始化
// 您应该正常初始化大多数字段，而不是延迟初始化
// 如果使用延迟初始化，请使用同步访问器
public class Singleton {


    private volatile static Singleton instance = null;
    private Singleton() {}

//    public static synchronized Singleton getInstancev1() {
//        if(instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    public static Singleton getInstancev2() {
        if(instance == null) {
            synchronized(Singleton.class) {
                if(instance == null) {
                    instance = new Singleton(); // 开辟内存、初始化、指向引用
                }
            }
        }
        return instance;
    }



}
