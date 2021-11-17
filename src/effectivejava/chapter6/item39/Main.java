package effectivejava.chapter6.item39;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 注解 优于 命名模式
// 命名模式：JUnit 测试框架要求其用户通过以字符 test 开头的名称来指定测试方法
public class Main {

    // 保留策略
    // SOURCE: 只在源文件中保留，在编译期间会被抛弃
    // CLASS: 在编译时被存储到 .class 文件中。但是，在运行时不能通过 JVM 得到这些注解
    // RUNTIME: 在编译时被存储到 .class 文件中，并且在运行时可以通过 JVM 获取这些注解
    @Retention(RetentionPolicy.RUNTIME)
    // 作用范围
    @Target(ElementType.METHOD)
    public @interface Test {

    }


    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
    }
}
