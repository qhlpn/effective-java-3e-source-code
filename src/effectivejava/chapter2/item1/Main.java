package effectivejava.chapter2.item1;


import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

// 考虑以静态工厂方法代替构造函数
public class Main {

    public static void main(String[] args) {

        Date date = Date.from(null);

        Set<Season> set = EnumSet.of(Season.SPRING, Season.SUMMER);

        BigInteger value = BigInteger.valueOf(Integer.MAX_VALUE);

        StackWalker walker = StackWalker.getInstance((StackWalker.Option) null);

        Object array = Array.newInstance(null, 0);

        ArrayList<String> list = Collections.list(null);


    }

    public enum Season {
        SPRING, SUMMER, FALL, WINTER
    }

}
