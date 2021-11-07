package effectivejava.chapter5.item29;

import java.util.Arrays;

// 消除 Stack 中泛型数组创建错误
// 方式一   Generic stack using E[] (Pages 130-3)
public class n1_Stack<E> {

    // E[]
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // The elements array will contain only E instances from push(E).
    // This is sufficient to ensure type safety, but the runtime
    // type of the array won't be E[]; it will always be Object[]!
    @SuppressWarnings("unchecked")
    public n1_Stack() {
        // 由 push E 可以保障这里 强转
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        // 无法创建非具体化类型的数组
        // elements = new E[DEFAULT_INITIAL_CAPACITY] // 编译出错
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // Little program to exercise our generic Stack
    public static void main(String[] args) {
        n1_Stack<String> stack = new n1_Stack<>();
        for (String arg : args)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}
