Lambdas and Streams（λ 表达式和流）

在 Java 8 中，为了更容易地创建函数对象，添加了函数式接口、lambda 表达式和方法引用；流 API 也与这些语言特性一并添加进来，为处理数据元素序列提供库支持。在这一章中，我们将讨论如何最好地利用这些工具。、

Item 42: Prefer lambdas to anonymous classes（λ 表达式优于匿名类）
Item 43: Prefer method references to lambdas（方法引用优于 λ 表达式）
Item 44: Favor the use of standard functional interfaces（优先使用标准函数式接口）
Item 45: Use streams judiciously（明智地使用流）
Item 46: Prefer side effect free functions in streams（在流中使用无副作用的函数）
Item 47: Prefer Collection to Stream as a return type（优先选择 Collection 而不是流作为返回类型）
Item 48: Use caution when making streams parallel（谨慎使用并行流）