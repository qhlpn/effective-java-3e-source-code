package effectivejava.chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 覆盖 equals 方法时要遵守 通用约定
// 1. 对称性
// 2. 传递性
public class Main {

    // 破坏了 对称性
    public static final class CaseInsensitiveString {
        private final String s;

        public CaseInsensitiveString(String s) {
            this.s = Objects.requireNonNull(s);
        }

        // Broken - violates symmetry!
        @Override
        public boolean equals(Object o) {
            if (o instanceof CaseInsensitiveString)
                return s.equalsIgnoreCase(
                        ((CaseInsensitiveString) o).s);
            if (o instanceof String)  // One-way interoperability!
                return s.equalsIgnoreCase((String) o);
            return false;
        }



        //    // Fixed equals method (Page 40)
        //    @Override public boolean equals(Object o) {
        //        return o instanceof CaseInsensitiveString &&
        //                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
        //    }
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(s));
    }


}
