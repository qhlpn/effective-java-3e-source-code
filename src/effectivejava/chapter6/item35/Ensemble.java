package effectivejava.chapter6.item35;

// 使用 实例字段 替代 序数ordinal
// 每个常量如果不用实例字段的方式，就只能有一个序号值。
// 实例字段可以将自定义的值对应多个常量，例如：SOLO(3), DUET(3), TRIO(3)，可以都设置为序号 3
public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}