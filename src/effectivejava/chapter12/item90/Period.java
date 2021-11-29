package effectivejava.chapter12.item90;


import java.util.*;
import java.io.*;

// 考虑以序列化代理代替序列化实例
// 当你发现必须在客户端不可扩展的类上编写 readObject 或 writeObject 方法时，请考虑序列化代理模式

// Period class with serialization proxy - Pages 363-364
// Immutable class that uses defensive copying
public final class Period implements Serializable {
    private final Date start;
    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end   the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException     if start or end is null
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public String toString() {
        return start + " - " + end;
    }

    // writeReplace method for the serialization proxy pattern
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // readObject method for the serialization proxy pattern
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }


    // Serialization proxy for Period class
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        // 序列化操作的时候系统会把当前类的 serialVersionUID 写入到序列化文件中，
        // 当反序列化时系统会去检测文件中的 serialVersionUID，判断它是否与当前类的 serialVersionUID 一致，
        // 如果一致就说明序列化类的版本与当前类版本是一样的，可以反序列化成功，否则失败。
        private static final long serialVersionUID = 234098243823485285L; // Any number will do (Item 87)
    }

}