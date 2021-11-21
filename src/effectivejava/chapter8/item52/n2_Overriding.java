package effectivejava.chapter8.item52;

import java.util.List;

// 覆盖方法的选择是动态的
// Classification using method overrriding (Page 239)
public class n2_Overriding {

    static class Champagne extends SparklingWine {
        @Override
        String name() {
            return "champagne";
        }
    }

    static class SparklingWine extends Wine {
        @Override
        String name() {
            return "sparkling wine";
        }
    }

    static class Wine {
        String name() {
            return "wine";
        }
    }


    public static void main(String[] args) {
        List<Wine> wineList = List.of(
                new Wine(), new SparklingWine(), new Champagne());

        for (Wine wine : wineList)
            System.out.println(wine.name());
    }
}
