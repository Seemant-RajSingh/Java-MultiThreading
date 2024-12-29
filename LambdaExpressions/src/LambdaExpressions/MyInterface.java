package LambdaExpressions;
// this is a functional interface cause 1 abstract method
public interface MyInterface {

    void printIt(); // abstract, no access modifier req?

    default public void printIt2() {
        System.out.println("print from default method");
    }

    static public void printIt3() {
        System.out.println("print from static");
    }
}
