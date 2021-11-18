package effectivejava.chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.*;

// 在流中使用无副作用的函数
// 流的操作类型分3种：
//      1、Intermediate: 一个流可以后面跟随零个或多个 intermediate 操作
//                       其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，交给下一个操作使用
//                       这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历
//                       map、filter、distinct、sorted、peek、limit、skip、parallel、sequential、unordered
//      2、Terminal: 一个流只能有一个 terminal 操作，当这个操作执行后，流就被使用「光」了，无法再被操作，所以这必定是流的最后一个操作
//                   Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect
//                   程序设计中，没有副作用(side effect)的函数，他们只做输入值到输出值映射的计算
//                   函数的所有其他行为都叫副作用，访问全局变量，读写文件，网络传输，界面交互显示，等等等等
//                   forEach、forEachOrdered、toArray、reduce、collect、min、max、count、anyMatch、allMatch、noneMatch、findFirst、findAny、iterator
//      3、Short-Circuiting: 流元素理论上是无限的，如果想对无限的流做限制 则需要 Short-Circuiting ，如
//                           Intermediate 操作 接受的是一个无限大（infinite/unbounded）的流，返回有限的流
//                           Terminal 操作 接受的是一个无限大的流，但能在有限的时间计算出结果
//                           anyMatch、allMatch、 noneMatch、findFirst、findAny、limit
//
public class Freq {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);

        // Uses the streams API but not the paradigm--Don't do this!
        // 简单地说，它根本不是流代码，而是伪装成流代码的迭代代码
        // 这段代码在一个 Terminal 操作中（forEach）执行它的所有工作
        // forEach 操作应该只用于报告流计算的结果，而不是执行计算
        Map<String, Long> freq = new HashMap<>();
        try (Stream<String> words = new Scanner(file).tokens()) {
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }

        // Proper use of streams to initialize a frequency table (
        // 将流的元素收集到一个真正的 Collection 中的 collector 非常简单。
        // 这样的 collector 有三种：toList()、toSet() 和 toCollection(collectionFactory)
        Map<String, Long> freq1;
        try (Stream<String> words = new Scanner(file).tokens()) {
            freq1 = words.collect(groupingBy(String::toLowerCase, counting()));
        }
        System.out.println(freq1);

        // Pipeline to get a top-ten list of words from a frequency table
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        System.out.println(topTen);
    }
}
