package effectivejava.chapter8.item55;

// 明智地的返回 Optional
// 1. 永远不要从具备 Optional 返回值的方法返回空值: 它违背了这个功能的设计初衷
// 2. 容器类型，包括集合、Map、流、数组和 Optional，不应该封装在 Optional 中
// 3. 永远不应该返回 基础类型的包装类 的 Optional（可以用 OptionalInt、OptionalLong 和 OptionalDouble 代替），
//    可能除了「次基本数据类型」，如 Boolean、Byte、Character、Short 和 Float 之外。
// 4. 在集合或数组中使用 Optional 作为键、值或元素几乎都是不合适的。
// 总之，如果你发现自己编写的方法不能总是返回确定值，并且你认为该方法的用户在每次调用时应该考虑这种可能性，那么你可能应该让方法返回一个 Optional。
// 但是，你应该意识到，返回 Optional 会带来实际的性能后果；对于性能关键的方法，最好返回 null 或抛出异常。
// 最后，除了作为返回值之外，你几乎不应该以任何其他方式使用 Optional。
public class Main {
}
