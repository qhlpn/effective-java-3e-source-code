Generics（泛型）
在泛型出现之前，从集合中读取的每个对象都必须进行强制转换。如果有人不小心插入了错误类型的对象，强制类型转换可能在运行时失败。
对于泛型，你可以告知编译器在每个集合中允许哪些类型的对象。编译器会自动为你进行强制转换与插入的操作，如果你试图插入类型错误的对象，编译器会在编译时告诉你。
但是这些好处不仅仅局限于集合，而且也是有代价的。这一章会告诉你如何最大限度地扬长避短。

Item 26: Do not use raw types（不要使用原始类型）
Item 27: Eliminate unchecked warnings（消除 unchecked 警告）
Item 28: Prefer lists to arrays（list 优于数组）
Item 29: Favor generic types（优先使用泛型）
Item 30: Favor generic methods（优先使用泛型方法）
Item 31: Use bounded wildcards to increase API flexibility（使用有界通配符增加 API 的灵活性）
Item 32: Combine generics and varargs judiciously（明智地合用泛型和可变参数）
Item 33: Consider typesafe heterogeneous containers（考虑类型安全的异构容器）



为了便于参考，本条目中介绍的术语（以及将要介绍的一些术语）总结如下：

| 术语           | 例子                               |
| -------------- | ---------------------------------- |
| 参数化类型     | `List<String>`                     |
| 实际类型参数   | `String`                           |
| 通用型         | `List<E>`                          |
| 正式类型参数   | `E`                                |
| 无界通配符类型 | `List<?>`                          |
| 原始类型       | `List`                             |
| 有界类型参数   | `<E extends Number>`               |
| 递归类型绑定   | `<T extends Comparable<T>>`        |
| 有界通配符类型 | `List<? extends Number>`           |
| 通用方法       | `static <E> List<E> asList(E[] a)` |
| 类型令牌       | `String.class`                     |