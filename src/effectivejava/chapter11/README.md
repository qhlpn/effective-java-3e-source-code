### Concurrency（并发）

线程允许多个活动并发进行。并发编程比单线程编程更困难，容易出错的地方更多，而且失败很难重现。

你无法避开并发。它是平台中固有的，并且多核处理器现在也是无处不在，而你会有从多核处理器获得良好的性能的需求。

本章包含一些建议，帮助你编写清晰、正确、文档良好的并发程序。





Item 78: Synchronize access to shared mutable data（对共享可变数据的同步访问）

Item 79: Avoid excessive synchronization（避免过度同步）

Item 80: Prefer executors, tasks, and streams to threads（Executor、task、流优于直接使用线程）

Item 81: Prefer concurrency utilities to wait and notify（并发实用工具优于 wait 和 notify）

Item 82: Document thread safety（文档应包含线程安全属性）

Item 83: Use lazy initialization judiciously（明智地使用延迟初始化）

Item 84: Don’t depend on the thread scheduler（不要依赖线程调度器）