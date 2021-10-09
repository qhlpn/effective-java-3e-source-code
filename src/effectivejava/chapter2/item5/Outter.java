package effectivejava.chapter2.item5;


import java.util.function.Supplier;


// 优先考虑 依赖注入 来引用资源
// 即将资源或资源工厂传给构造函数（或者静态工厂）
public class Outter {

    private Inner inner;

    public Outter(Inner inner) {
        this.inner = inner;
    }

    public Outter create(Supplier<? extends Inner> innerSupplier) {
        this.inner = innerSupplier.get();
        return this;
    }


    public static class Inner {

    }

}
