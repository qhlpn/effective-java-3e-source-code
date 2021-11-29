package effectivejava.chapter12.item86;

import java.io.*;

// 非常谨慎地实现 Serializable
// 实现 Serializable 接口的主要代价是
// 1. 一旦类的实现被发布，它就会降低更改该类实现的灵活性。
//    当类实现 Serializable 时，其字节流编码（或序列化形式）成为其导出 API 的一部分。
//    一旦广泛分发了一个类，通常就需要永远支持序列化的形式。
// 2. 增加了出现 bug 和安全漏洞的可能性（item85）
public class Main {


    public static void main(String[] args) {
        writeSerializableObject();
        readSerializableObject();
    }

    public static void writeSerializableObject() {
        try {
            Man man = new Man("root");
            Person person = new Person(man, "root", 21);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("serialize.txt"));
            objectOutputStream.writeObject("string");
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readSerializableObject() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serialize.txt"));
            String string = (String) objectInputStream.readObject();
            Person person = (Person) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(string + ", age: " + person.getAge() + ", man username: " + person.getMan().getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static class Man implements Serializable {

        private static final long serialVersionUID = 1L;

        private String username;

        public Man(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        private Man man;
        private String username;
        private transient int age;

        public Person() {
            System.out.println("person constru");
        }

        public Person(Man man, String username, int age) {
            this.man = man;
            this.username = username;
            this.age = age;
        }

        public Man getMan() {
            return man;
        }
        public void setMan(Man man) {
            this.man = man;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

}
