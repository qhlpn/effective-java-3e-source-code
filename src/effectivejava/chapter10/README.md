Exceptions（异常）

当充分利用好异常时，可以提高程序的可读性、可靠性和可维护性。如果使用不当，则会产生负面效果。本章提供了有效使用异常的指南

Item 69: Use exceptions only for exceptional conditions（仅在确有异常条件下使用异常）
Item 70: Use checked exceptions for recoverable conditions and runtime exceptions for programming errors（对可恢复情况使用 checked 异常，对编程错误使用运行时异常）
Item 71: Avoid unnecessary use of checked exceptions（避免不必要地使用 checked 异常）
Item 72: Favor the use of standard exceptions（鼓励复用标准异常）
Item 73: Throw exceptions appropriate to the abstraction（抛出能用抽象解释的异常）
Item 74: Document all exceptions thrown by each method（为每个方法记录会抛出的所有异常）
Item 75: Include failure capture information in detail messages（异常详细消息中应包含捕获失败的信息）
Item 76: Strive for failure atomicity（尽力保证故障原子性）
Item 77: Don’t ignore exceptions（不要忽略异常）



                    Throwable

        Error                      Exception
   
                
                       RuntimeException   other-exception


首先，Throwable标志这是一个异常。
其次，Throwable有两个子类分别是Error和Exception，Error表示的是JVM发生的异常，如内存溢出，这是应用自身程序本身无法处理的异常；而Exception则表示应用程序自身可以处理的异常。
最后，Exception的子类分为两类，一个是RuntimeException，另外就是其他继承自Exception的异常，如IOException。区分这两类异常主要特性是是否受检。