package effectivejava.chapter5.item32;

import java.util.ArrayList;
import java.util.List;

// List as a typesafe alternative to a generic varargs parameter (page 149)
public class n2_FlattenWithList {

    // 也可以用 List 参数替换 可变参数 解决警告
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> flatList = flatten(List.of(
                List.of(1, 2), List.of(3, 4, 5), List.of(6, 7)));
        System.out.println(flatList);
    }
}
