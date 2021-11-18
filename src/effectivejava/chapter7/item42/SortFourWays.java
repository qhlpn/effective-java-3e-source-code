package effectivejava.chapter7.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

import static java.util.Comparator.comparingInt;

// λ 表达式优于匿名类
// 不要对函数对象使用匿名类，除非你必须创建非函数式接口类型的实例
public class SortFourWays {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);

        // Anonymous class instance as a function object - obsolete! (Page 193)
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(words);
        Collections.shuffle(words);

        // Lambda expression as function object (replaces anonymous class) (Page 194)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words);
        Collections.shuffle(words);

        // Comparator construction method (with method reference) in place of lambda (Page 194)
        // comparingInt 是 Comparator 构造方法
        // comparingInt = Integer.compare

        // :: -> 方法引用
        // 可以通过 :: 来访问类的构造方法，对象方法，静态方法
        // 使用 lambda 表达式会创建匿名方法， 但有时候 lambda 只调用一个已经存在的方法（不做其它）[每个元素都传到该方法里面执行一下]，
        // 方法引用 是 lambda 更简洁的表现形式
        Collections.sort(words, comparingInt(String::length));
        System.out.println(words);
        Collections.shuffle(words);


        // Default method List.sort in conjunction with comparator construction method (Page 194)
        words.sort(comparingInt(String::length));
        System.out.println(words);
    }
}
