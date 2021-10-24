package effectivejava.chapter3.item13;

import java.util.HashMap;
import java.util.Map;

// 假设你希望在一个类中实现 Cloneable 接口
// 如果该类的超类已经提供了一个合适的 clone 方法。
// 则应该调用 super.clone()
public final class n2_PhoneNumber implements Cloneable {
    private final int areaCode, prefix, lineNum;

    public n2_PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    // 虽然 Object 的 clone 方法返回 Object 类型，但是这个 clone 方法返回 PhoneNumber 类型
    // 这样做是合法的，也是可取的，因为 Java 的返回值类型支持协变
    // 覆盖方法的返回类型可以是被覆盖方法的返回类型的子类
    @Override
    public n2_PhoneNumber clone() {
        try {
            return (n2_PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // Can't happen
        }
    }

    public static void main(String[] args) {
        n2_PhoneNumber pn = new n2_PhoneNumber(707, 867, 5309);
        Map<n2_PhoneNumber, String> m = new HashMap<>();
        m.put(pn, "Jenny");
        System.out.println(m.get(pn.clone()));
    }
}
