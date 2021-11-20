package effectivejava.chapter8.item50;

import java.util.*;

// 在需要时制作防御性副本
// 乍一看，这个类似乎是不可变的，并且要求一个时间段的开始时间不能在结束时间之后。
// 然而，利用 Date 是可变的这一事实很容易绕过这个约束： 看 psvm
// 从 Java 8 开始，解决这个问题的典型方法就是使用 Instant（或 Local-DateTime 或 ZonedDateTime）来代替 Date，
// 因为 Instant（和其他时间类）类是不可变的（Item-17）。Date 已过时，不应在新代码中使用
public final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(
                    start + " after " + end);
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

    public String toString() {
        return start + " - " + end;
    }

    // Remainder omitted

    public static void main(String[] args) {
        // Attack the internals of a Period instance  (Page 232)
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        end.setYear(78);  // Modifies internals of p!
        System.out.println(p);

        // Second attack on the internals of a Period instance  (Page 233)
        start = new Date();
        end = new Date();
        p = new Period(start, end);
        p.end().setYear(78);  // Modifies internals of p!
        System.out.println(p);
    }
}