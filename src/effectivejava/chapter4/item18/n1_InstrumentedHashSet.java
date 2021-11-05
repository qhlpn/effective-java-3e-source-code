package effectivejava.chapter4.item18;

import java.util.*;

// 优先选择复合而不是继承
// 继承破坏了封装，超类的实现可能在版本之间发生变化，如果发生了变化，子类可能会崩溃
public class n1_InstrumentedHashSet<E> extends HashSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;

    public n1_InstrumentedHashSet() {
    }

    public n1_InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        // 在 HashSet 内部，addAll 方法是基于 add 方法实现的
        // InstrumentedHashSet 中的 addAll 方法使 addCount 变量增加了 3，
        // 然后通过 super.addAll 调用 HashSet 的 addAll 实现。这相当于反过来调用在 InstrumentedHashSet 中被覆盖的 add 方法，每个元素一次
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        n1_InstrumentedHashSet<String> s = new n1_InstrumentedHashSet<>();
        s.addAll(List.of("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}
