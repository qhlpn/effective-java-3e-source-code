package effectivejava.chapter4.item20;

import java.util.*;

// 接口优于抽象类（Java 只允许单一继承限制了抽象类）
// 接口是定义 mixin（混合类型）的理想工具

// 模板方法模式
// 使用 抽象骨架 实现类来结合接口和抽象类的优点
// 接口定义了类型，提供了一些默认方法，而骨架实现类在基本接口方法之上实现了其余的非基本接口方法
public abstract class n1_AbstractMapEntry<K, V>
        implements Map.Entry<K, V> {
    // Entries in a modifiable map must override this method
    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    // Implements the general contract of Map.Entry.equals
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Map.Entry))
            return false;
        Map.Entry<?, ?> e = (Map.Entry) o;
        return Objects.equals(e.getKey(), getKey())
                && Objects.equals(e.getValue(), getValue());
    }

    // Implements the general contract of Map.Entry.hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey())
                ^ Objects.hashCode(getValue());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }


    static class ConcreteMapEntry extends n1_AbstractMapEntry {

        @Override
        public Object getKey() {
            return null;
        }

        @Override
        public Object getValue() {
            return null;
        }
    }

}
