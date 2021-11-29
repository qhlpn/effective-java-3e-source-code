package effectivejava.chapter11.item81;

import java.util.concurrent.*;

// 并发实用工具优于 wait 和 notify
// 如果维护使用 wait 和 notify 的代码，请确保它始终使用标准的习惯用法，
// 即在 while 循环中调用 wait。而且，notifyAll 方法通常应该优先于 notify。

// Concurrent canonicalizing map atop ConcurrentMap - Pages 273-274
public class n1_Intern {

    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();


    // String::intern() 放进常量池
    public static String internv1(String s) {
        // putIfAbsent 线程安全
        String previousValue = map.putIfAbsent(s, s);
        return previousValue == null ? s : previousValue;
    }

    // Concurrent canonicalizing map atop ConcurrentMap - faster!
    public static String internv2(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null)
                result = s;
        }
        return result;
    }
}