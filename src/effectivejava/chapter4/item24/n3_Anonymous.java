package effectivejava.chapter4.item24;

public class n3_Anonymous {

    // 假设嵌套类属于方法内部，
    // 如果你只需要从一个位置创建实例，并且存在一个能够描述类的现有类型，那么将其设置为匿名类
    // 否则，将其设置为局部类
    public static void main(String[] args) {

        new Thread(
                // 匿名类 lambdas
                ()-> System.out.println("~~~~~~~~~~")).start();

    }

}
