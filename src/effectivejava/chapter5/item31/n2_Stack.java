package effectivejava.chapter5.item31;

import java.util.*;

// Generic stack with bulk methods using wildcard types (Pages 139-41)
// 区分生产者消费者 （针对的是对象内部而言）
public class n2_Stack<E> {

    private E[] elements;

    // Wildcard type for parameter that serves as an E producer
    // 生产 E[] elements
    // ? extends E
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src)
            push(e);
    }


    // Wildcard type for parameter that serves as an E consumer
    // 消费 E[] elements
    // ? super E
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }




    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // The elements array will contain only E instances from push(E).
    // This is sufficient to ensure type safety, but the runtime
    // type of the array won't be E[]; it will always be Object[]!
    @SuppressWarnings("unchecked")
    public n2_Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
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

//    // pushAll staticfactory without wildcard type - deficient!
//    public void pushAll(Iterable<E> src) {
//        for (E e : src)
//            push(e);
//    }



    // Little program to exercise our generic Stack
    public static void main(String[] args) {
        n2_Stack<Number> numberStack = new n2_Stack<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll(integers);

        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);

        System.out.println(objects);
    }
}
