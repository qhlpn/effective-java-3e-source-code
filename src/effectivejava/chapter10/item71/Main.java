package effectivejava.chapter10.item71;

// 避免不必要地使用 checked 异常，它们强制程序员处理问题，它给 API 的用户带来了负担
// 如果恢复是可能的，并且你希望强制调用者处理异常条件，那么首先考虑返回一个 Optional 对象。
// 只有当在失败的情况下，提供的信息不充分时，你才应该抛出一个 checked 异常。
public class Main {
}
