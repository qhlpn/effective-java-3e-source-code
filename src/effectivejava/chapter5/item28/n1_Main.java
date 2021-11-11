package effectivejava.chapter5.item28;

import java.util.ArrayList;
import java.util.List;

// 优先使用 List + 泛型，而不是 数组
// 泛型是不变的，由擦除实现的，提供编译时类型安全
// 数组是协变的，提供了运行时类型安全
public class n1_Main {

    public static void main(String[] args) {

        // 数组是协变的
        // 如果 Sub 是 Super 的一个子类型，那么数组类型 Sub[] 就是数组类型 Super[] 的一个子类型
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in";

        // 泛型是不变的
        // 对于任何两个不同类型 Type1 和 Type2，List<Type1> 既不是 List<Type2> 的子类型，也不是 List<Type2> 的超类型
        // List<Object> ol = new ArrayList<Long>();  // 编译出错
        // ArrayList<Object> ol = new ArrayList<Long>();  // 编译出错
        List<Long> o3 = new ArrayList<Long>();  // 编译成功
        // 有界通配符类型
        List<? extends Object> ol = new ArrayList<Long>();
        ArrayList<? extends Object> o2 = new ArrayList<Long>();

        // 泛型数组 是不合法的
//         List<String>[] stringLists = new List<String>[1];  // 编译出错
//         List<String>[] stringLists = (List<String>[]) new Object[1];  // 编译成功


        // 泛型是由擦除实现的
        // List<Integer> 实例的运行时类型是 List，List<String>[] 实例的运行时类型是 List[]
    }

}
