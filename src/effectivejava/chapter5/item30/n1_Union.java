package effectivejava.chapter5.item30;

import java.util.*;

// Generic union method and program to exercise it  (Pages 135-6)
// 优先使用泛型方法
public class n1_Union {

    // Generic method
    // <E> 非具体化类型 需要庭前声明
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public void run(Set<String> set) {
        System.out.println(set.size());
    }

    // Simple program to exercise generic method
    public static void main(String[] args) {
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }
}
