package effectivejava.chapter12.item85;

import static effectivejava.chapter12.item85.DeserializationBomb.Util.*;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

// 序列化是危险的，应该避免。
// 如果你从头开始设计一个系统，可以使用跨平台的结构化数据，如 JSON 或 protobuf。
// 不要反序列化不可信的数据。
// 如果必须这样做，请使用对象反序列化过滤 java.io.ObjectInputFilter
public class DeserializationBomb {

    public static void main(String[] args) throws Exception {

        System.out.println(bomb().length);
        // 对象图由 201 个 HashSet 实例组成，每个实例包含 3 个或更少的对象引用。整个流的长度为 5744 字节，但是在你对其进行反序列化之前，资源就已经耗尽了。
        // 反序列化 HashSet 实例需要计算其元素的哈希码。反序列化 Set 会导致 hashCode 方法被调用超过 2100 次
        // 除了反序列化会持续很长时间之外，反序列化器没有任何错误的迹象。生成的对象很少，并且堆栈深度是有界的
        deserialize(bomb());
    }

    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo"); // make it not equal to t2
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        return serialize(root);
    }

    public static class Util {
        public static byte[] serialize(Object o) {
            ByteArrayOutputStream ba = new ByteArrayOutputStream();
            try {
                new ObjectOutputStream(ba).writeObject(o);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
            return ba.toByteArray();
        }

        public static Object deserialize(byte[] bytes) {
            try {
                return new ObjectInputStream(
                        new ByteArrayInputStream(bytes)).readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

}
