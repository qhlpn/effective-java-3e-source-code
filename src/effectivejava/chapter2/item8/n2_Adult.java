package effectivejava.chapter2.item8;

// try-with-resources
public class n2_Adult {
    public static void main(String[] args) {
        try (n1_Room myRoom = new n1_Room(7)) {
            System.out.println("Goodbye");
        }
    }
}
