package effectivejava.chapter5.item32;

import java.util.ArrayList;
import java.util.List;

// 可变参数方法和泛型不能很好地交互

// 泛型可变参数不是类型安全的，但它们是合法的
// 泛型数组 则不是合法的，无法编译通过
// item28 泛型数组
// List<String>[] stringLists = new List<String>[1];  // 编译出错
// List<String>[] stringLists = (List<String>[]) new Object[1];  // 编译成功
// E[] e = new E[1] // 编译出错
// E[] e = (E[]) new Object[1] // 编译成功  n3_PickTwo
public class n1_FlattenWithVarargs {
    @SafeVarargs
    // 如果选择使用泛型（或参数化）可变参数编写方法，首先要确保该方法是类型安全的，然后使用 @SafeVarargs 对其进行注释
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> flatList = flatten(
                List.of(1, 2), List.of(3, 4, 5), List.of(6, 7));
        System.out.println(flatList);
    }
}
