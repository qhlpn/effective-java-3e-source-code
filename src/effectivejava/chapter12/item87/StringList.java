package effectivejava.chapter12.item87;

import java.io.*;

// 考虑使用自定义序列化形式
// 只有在合理描述对象的逻辑状态时，才使用默认的序列化形式

// StringList with a reasonable custom serialized form  - Page 349
public final class StringList implements Serializable {

    // 将不需要序列化的属性前添加关键字transient，序列化 Serializable 对象的时候，这个属性就不会序列化
    // 若实现的是 Externalizable 接口，则没有任何东西可以自动序列化，需要在 writeExternal 方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关。
    private transient int size = 0;
    private transient Entry head = null;

    // No longer Serializable!
    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    // Appends the specified string to the list
    public final void add(String s) {
    }

    /**
     * Serialize this {@code StringList} instance.
     *
     * @serialData The size of the list (the number of strings
     * it contains) is emitted ({@code int}), followed by all of
     * its elements (each a {@code String}), in the proper
     * sequence.
     */
    private void writeObject(ObjectOutputStream s)
            throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (Entry e = head; e != null; e = e.next)
            s.writeObject(e.data);
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        // Read in all elements and insert them in list
        for (int i = 0; i < numElements; i++)
            add((String) s.readObject());
    }

    // Remainder omitted
}
