package effectivejava.chapter2.item7;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class n2_WeakHashMap {

    public static void main(String[] args) throws Exception {

        // WeakHashMap，此种Map的特点是，当除了自身有对key的引用外，此key没有其他引用那么此map会自动丢弃此值，适合做缓存
        String a = "a";
        String b = "b";
        Map<String, String> map = new HashMap<>();
        map.put(a, "aaa");
        map.put(b, "bbb");

        Map<String, String> weakmap = new WeakHashMap<>();
        weakmap.put(a, "aaa");
        weakmap.put(b, "bbb");

        map.remove(a);
        a = null;
        b = null;

        System.gc();

        Thread.sleep(10000);

        for (Map.Entry<String, String> en : map.entrySet()) {
            System.out.println("map:" + en.getKey() + ":" + en.getValue());
        }

        for (Map.Entry<String, String> en : weakmap.entrySet()) {
            System.out.println("weakmap:" + en.getKey() + ":" + en.getValue());
        }

    }
}
