package effectivejava.chapter3.item14;

import java.util.Comparator;

// 考虑实现 Comparable 接口
// Comparable: 内比较器  int compareTo(Object o)
// Comparator: 外比较器  int compare(Object l, Object r)   定义比较的策略
public class Main implements Comparable<Main> {

    // 在比较字段值时，不要使用这种写法
    // 如果第一个值小于第二个值，则两个值之间的差为负；如果两个值相等，则为零；如果第一个值大于零，则为正，
    // 它充满了来自整数溢出和 IEEE 754 浮点运算构件的危险
    //    static Comparator<Object> hashCodeOrder = new Comparator<>() {
    //        @Override
    //        public int compare(Object o1, Object o2) {
    //            return o1.hashCode() - o2.hashCode();
    //        }
    //    };


    static Comparator<Main> hashCodeOrder = Comparator.comparingInt(o -> o.hashCode());

    @Override
    public int compareTo(Main o) {
        // 在 compareTo 方法的实现中比较字段值时，避免使用 < 和 > 操作符，
        // 应使用包装类中的静态比较方法 Integer.compare / Double.compare
        // 或 Comparator 接口中的 comparator 构造方法
        return hashCodeOrder.compare(this, o);
    }
}
