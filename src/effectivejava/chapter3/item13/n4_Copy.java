package effectivejava.chapter3.item13;

// 使用复制构造函数来实现克隆
// 许多优点：
//      它们不依赖于易发生风险的语言外对象创建机制；
//      他们不要求无法强制执行的约定；
//      它们与最终字段的正确使用不冲突；
//      它们不会抛出不必要的检查异常，而且不需要强制类型转换。
public class n4_Copy {

    public n4_Copy() {

    }

    public n4_Copy n4_copy(n4_Copy n4_copy) {
        return new n4_Copy();
    }

}
