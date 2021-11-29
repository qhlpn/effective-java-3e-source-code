### Methods Common to All Objects（对象的通用方法）

虽然 Object 是一个具体的类，但它主要是为扩展而设计的。它的所有非 final 方法（equals、hashCode、toString、clone 和 finalize）都有显式的通用约定，因为它们的设计目的是被覆盖。

本章将告诉你何时以及如何覆盖 Object 类的非 final 方法。



Item 10: Obey the general contract when overriding equals（覆盖 equals 方法时应遵守的约定）

Item 11: Always override hashCode when you override equals（当覆盖 equals 方法时，总要覆盖 hashCode 方法）

Item 12: Always override toString（始终覆盖 toString 方法）

Item 13: Override clone judiciously（明智地覆盖 clone 方法）

Item 14: Consider implementing Comparable（考虑实现 Comparable 接口）