package effectivejava.chapter10.item72;

// 鼓励复用标准异常，它使你的 API 更容易学习和使用，因为它符合程序员已经熟悉的既定约定。
public class Main {


    // 不要直接复用 Exception、RuntimeException、Throwable 或 Error。 应当将这些类视为抽象类。

    // 最常见的可复用异常：

    // IllegalArgumentException	            Non-null parameter value is inappropriate（非空参数值不合适）
    // IllegalStateException	            Object state is inappropriate for method invocation（对象状态不适用于方法调用）
    // NullPointerException	                Parameter value is null where prohibited（禁止参数为空时仍传入 null）
    // IndexOutOfBoundsException	        Index parameter value is out of range（索引参数值超出范围）
    // ConcurrentModificationException  	Concurrent modification of an object has been detected where it is prohibited（在禁止并发修改对象的地方检测到该动作）
    // UnsupportedOperationException	    Object does not support method（对象不支持该方法调用）

}
