package effectivejava.chapter4.item18;

import java.util.*;

// 优先选择复合而不是继承
public class n2_ForwardingSet<E> implements Set<E> {
    private final Set<E> s;

    public n2_ForwardingSet(Set<E> s) {
        this.s = s;
    }

    @Override
    public void clear() {
        s.clear();
    }

    @Override
    public boolean contains(Object o) {
        return s.contains(o);
    }

    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }

    @Override
    public int size() {
        return s.size();
    }

    @Override
    public Iterator<E> iterator() {
        return s.iterator();
    }

    @Override
    public boolean add(E e) {
        return s.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return s.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return s.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        System.out.println(this);
        return s.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return s.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }

    @Override
    public Object[] toArray() {
        return s.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return s.toArray(a);
    }

    @Override
    public boolean equals(Object o) {
        return s.equals(o);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s.toString();
    }

    static class InstrumentedSet<E> extends n2_ForwardingSet<E> {
        private int addCount = 0;


        public InstrumentedSet(Set<E> s) {
            super(s);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            System.out.println(this);
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }

        public static void main(String[] args) {
            InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
            s.addAll(List.of("Snap", "Crackle", "Pop"));
            System.out.println(s.getAddCount());
        }
    }

}
