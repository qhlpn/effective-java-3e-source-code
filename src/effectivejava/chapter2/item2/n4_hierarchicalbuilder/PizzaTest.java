package effectivejava.chapter2.item2.n4_hierarchicalbuilder;

import static effectivejava.chapter2.item2.n4_hierarchicalbuilder.Pizza.Topping.*;
import static effectivejava.chapter2.item2.n4_hierarchicalbuilder.NyPizza.Size.*;

// builder 模式也适用于类层次结构
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}
