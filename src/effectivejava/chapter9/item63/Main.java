package effectivejava.chapter9.item63;

// 当心字符串连接引起的性能问题
// 字符串串联运算符重复串联 n 个字符串需要 n 的平方级时间，当连接两个字符串时，将复制这两个字符串的内容
// 要获得能接受的性能，请使用 StringBuilder 的 append 方法 代替 String 来存储正在构建的语句
public class Main {
}
