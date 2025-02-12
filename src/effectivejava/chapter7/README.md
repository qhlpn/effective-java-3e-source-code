### Lambdas and Streams（λ 表达式和流）

在 Java 8 中，为了更容易地创建函数对象，添加了函数式接口、lambda 表达式和方法引用；流 API 也与这些语言特性一并添加进来，为处理数据元素序列提供库支持。在这一章中，我们将讨论如何最好地利用这些工具。、



Item 42: Prefer lambdas to anonymous classes（λ 表达式优于匿名类）

Item 43: Prefer method references to lambdas（方法引用优于 λ 表达式）

Item 44: Favor the use of standard functional interfaces（优先使用标准函数式接口）

Item 45: Use streams judiciously（明智地使用流）

Item 46: Prefer side effect free functions in streams（在流中使用无副作用的函数）

Item 47: Prefer Collection to Stream as a return type（优先选择 Collection 而不是流作为返回类型）

Item 48: Use caution when making streams parallel（谨慎使用并行流）



| 函数接口       | 抽象方法        | 功能                   | 参数   | 返回类型 |
| :------------- | :-------------- | :--------------------- | :----- | :------- |
| Predicate      | test(T t)       | 判断真假               | T      | boolean  |
| Consumer       | accept(T t)     | 消费消息               | T      | void     |
| Function       | R apply(T t)    | 将T映射为R（转换功能） | T      | R        |
| Supplier       | T get()         | 生产消息               | None   | T        |
| UnaryOperator  | T apply(T t)    | 一元操作               | T      | T        |
| BinaryOperator | apply(T t, U u) | 二元操作               | (T，T) | (T)      |

| Stream流函数              | 功能                                                  | 底层       | 类型         |
| :------------------------ | :---------------------------------------------------- | :--------- | :----------- |
| s.collect                 | 流转换成集合，Collectors.toList() / toSet() / toMap() |            | Terminal     |
| s.filter                  | 过滤筛选                                              | Predicate  | Intermediate |
| s.map                     | 映射转换                                              | Function   | Intermediate |
| s.flatMap                 | 将多个Stream合并成一个Stream                          | Function   | Intermediate |
| s.max / min               | 流中最大和值最小值                                    | Comparator | Terminal     |
| s.count                   | 流元素个数                                            |            | Terminal     |
| s.reduce                  | 累计操作                                              |            | Terminal     |
| Collectors.partitioningBy | 将流拆分成两个集合                                    | Predicate  |              |
| Collectors.groupingBy     | 将流元素进行集合分组                                  | Function   |              |