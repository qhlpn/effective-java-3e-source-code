package effectivejava.chapter3.item13;

public class n1_Base {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new n1_Base();
//        return super.clone();
    }



    static class BasePro extends n1_Base implements Cloneable {
        @Override protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public static void main(String[] args) throws Exception {
            BasePro basePro = new BasePro();
            System.out.println(basePro.clone().getClass()); // 输出 class com.example.demo.Base
            System.out.println(basePro.getClass()); // 输出 class com.example.demo.BasePro
        }
    }


}
