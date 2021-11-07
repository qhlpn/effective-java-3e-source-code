package effectivejava.chapter5.item27;

import java.util.HashSet;
import java.util.Set;

// 力求消除所有 unchecked 警告
public class Main {

    public static void main(String[] args) {

        // uncheck
        Set<Object> s1 = new HashSet();

        // check
        Set<Object> s2 = new HashSet<>();
        Set<Object> s3 = new HashSet<Object>();




    }
}
