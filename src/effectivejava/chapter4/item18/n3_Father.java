package effectivejava.chapter4.item18;

public class n3_Father {

    public void run() {
        System.out.println(this);
        doRun();
    }

    public void doRun() {
        System.out.println(this);
        System.out.println("~~~~~~~ father ~~~~~");
    }

    public void walk() {
        System.out.println();
    }


    static class Son extends n3_Father{

        @Override
        public void run() {
            System.out.println(this);
            super.run();
        }

//        @Override
//        public void doRun() {
//            System.out.println(this);
//            System.out.println("~~~~~~ son ~~~~~~");
//        }

        public void sing() {
            System.out.println(this);
        }

        public static void main(String[] args) {
            Son son = new Son();
            son.run();

            ((n3_Father) son).run();

            son.walk();
            ((n3_Father) son).walk();

            son.sing();
//            ((n3_Father) son).sing();    // error
        }
    }

}
