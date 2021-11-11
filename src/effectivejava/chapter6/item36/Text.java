package effectivejava.chapter6.item36;

import java.util.*;

// 用 EnumSet 替代位字段

// 一些使用枚举而不是 int 常量的程序员在需要传递常量集时仍然坚持使用位字段
// 没有理由这样做，因为存在更好的选择。
// java.util 包提供 EnumSet 类来有效地表示从单个枚举类型中提取的值集。
public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n", Objects.requireNonNull(styles));
    }

    // Sample use
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}