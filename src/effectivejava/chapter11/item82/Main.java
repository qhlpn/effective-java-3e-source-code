package effectivejava.chapter11.item82;

// 文档应包含线程安全属性
// 方法声明中 synchronized 修饰符的存在是实现细节，而不是其 API 的一部分。它不能可靠地表明方法是线程安全的。
// 要启用安全的并发使用，类必须清楚地记录它支持的线程安全级别
// Immutable: 不可变的。这个类的实例看起来是常量。不需要外部同步。示例包括 String、Long 和 BigInteger。
// Unconditionally thread-safe: 无条件线程安全。该类的实例是可变的，但是该类具有足够的内部同步，因此无需任何外部同步即可并发地使用该类的实例。例如 AtomicLong 和 ConcurrentHashMap。
// Conditionally thread-safe: 有条件的线程安全。与无条件线程安全类似，只是有些方法需要外部同步才能安全并发使用。示例包括 Collections.synchronized 包装器返回的集合，其迭代器需要外部同步
// Not thread-safe: 非线程安全。该类的实例是可变的。要并发地使用它们，客户端必须使用外部同步来包围每个方法调用（或调用序列）。这样的例子包括通用的集合实现，例如 ArrayList 和 HashMap。
public class Main {
}
