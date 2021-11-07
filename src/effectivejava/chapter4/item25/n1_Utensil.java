package effectivejava.chapter4.item25;

// Two classes defined in one file. Don't ever do this!  (Page 115)
// 永远不要将多个顶层类或接口放在一个源文件中
// 所使用的定义会受源文件传给编译器的顺序的影响
class Utensil {
    static final String NAME = "pan";
}

class Dessert {
    static final String NAME = "cake";
}
