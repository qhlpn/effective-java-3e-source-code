package effectivejava.chapter10.item77;

// 不要忽略异常
// 如果你选择忽略异常，catch 块应该包含一条注释，解释为什么这样做是合适的，并且应该将变量命名为 ignore
public class Main {

    // Empty catch block ignores exception - Highly suspect!
    // try {
    //     ...
    // } catch (SomeException ignore) {
    //   some note ...
    // }

}
