package effectivejava.chapter3.item13;

import java.util.Arrays;

// 深拷贝: 成员变量也需要拷贝新的
public class n3_Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public n3_Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Clone method for class with references to mutable state
    @Override
    public n3_Stack clone() {
        try {
            n3_Stack result = (n3_Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Ensure space for at least one more element.
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // To see that clone works, call with several command line arguments
    public static void main(String[] args) {
        n3_Stack stack = new n3_Stack();
        for (String arg : args)
            stack.push(arg);
        n3_Stack copy = stack.clone();
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
        while (!copy.isEmpty())
            System.out.print(copy.pop() + " ");
    }

    public static class EmptyStackException extends IllegalStateException {
    }

}
