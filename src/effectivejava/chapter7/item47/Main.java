package effectivejava.chapter7.item47;

// 优先选择 Collection 而不是流作为返回类型
// 如果一个 API 只返回一个流，而一些用户希望使用 for-each 循环遍历返回的序列，那么这些用户将会感到沮丧。
// 因为流接口包含 Iterable 接口中惟一的抽象方法。
// 唯一阻止程序员使用 for-each 循环在流上迭代的是流不能扩展 Iterable。
public class Main {
}
