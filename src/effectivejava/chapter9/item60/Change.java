package effectivejava.chapter9.item60;

// 若需要精确答案就应避免使用 float 和 double 类型来进行四则运算
// 如果希望系统来处理十进制小数点，并且不介意不使用基本类型带来的不便和成本，请使用 BigDecimal（字符串操作不会有精度问题），但速度会慢
// 如果性能是最重要的，而且数值不是太大，可以使用 int 或 long，再 除以 10^N 得到小鼠
public class Change {
    // Broken - uses floating point for monetary calculation!
    public static void main(String[] args) {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
    }
}
