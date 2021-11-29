package effectivejava.chapter12.item89;

// 在可能的情况下，使用枚举类型强制实例控制不变量
// 如果这是不可能的，并且你需要一个既可序列化又实例控制的类，
// 那么你必须提供一个 readResolve 方法，并确保该类的所有实例字段都是基本类型，或使用 transient 修饰。


// 如果实现 Serializable 接口，该类将不再是单例的，readObject 方法会返回一个新创建的实例，这个实例与类初始化时创建的实例不同。
// 如果正在反序列化的对象的类定义了 readResolve 方法，新创建的对象反序列化之后，将在该对象上调用该方法。该方法返回的对象引用将代替新创建的对象返回。
// 如果你依赖 readResolve 进行实例控制，那么所有具有对象引用类型的实例字段都必须声明为 transient


import java.io.Serializable;

// Enum singleton - the preferred approach - Page 311
public enum Elvis implements Serializable {

    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

    // readResolve for instance control - you can do better!
    // 如果 Elvis 类要实现 Serializable 接口，下面的 readResolve 方法就足以保证其单例属性：
    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }
}