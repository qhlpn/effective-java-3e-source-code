package effectivejava.chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

// 方法引用 :: 优于 λ 表达式
// 可以通过 :: 来访问类的构造方法，对象方法，静态方法
// 使用 lambda 表达式会创建匿名方法， 但有时候 lambda 只调用一个已经存在的方法（不做其它）[每个元素都传到该方法里面执行一下]，
// 方法引用 是 lambda 更简洁的表现形式
// Integer::sum = (a,b)-> Integer.sum(a,b)
public class Freq {
    public static void main(String[] args) {
        Map<String, Integer> frequencyTable = new TreeMap<>();

        for (String s : args)
            frequencyTable.merge(s, 1, (count, incr) -> count + incr); // Lambda
        System.out.println(frequencyTable);

        frequencyTable.clear();
        for (String s : args)
            frequencyTable.merge(s, 1, Integer::sum); // Method reference
        System.out.println(frequencyTable);

    }
}
