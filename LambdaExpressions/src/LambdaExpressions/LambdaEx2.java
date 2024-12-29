package LambdaExpressions;

public class LambdaEx2 {

    public static void main(String[] args) {
        MyInterface m1 = () -> {
            System.out.println("print from lambda exp");
        };

        MyInterface m2 = () -> {
            System.out.println("print from lambda exp 2");
        };

        m1.printIt();
        m1.printIt2();
        m2.printIt2();
//        m2.printIt3();    // instances cant call interface static method
        MyInterface.printIt3(); // static method called by
    }
}
