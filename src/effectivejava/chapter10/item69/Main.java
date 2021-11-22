package effectivejava.chapter10.item69;

// 仅在确有异常条件下使用异常
// 异常只适用于确有异常的情况；它们不应该用于一般的控制流程
public class Main {

    public static void main(String[] args) {

        int[] arr = new int[]{1};
        // Horrible abuse of exceptions. Don't ever do this!
        try {
            int i = 0;
            while (true) {
                arr[i++] = 1;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
        }

    }
}
