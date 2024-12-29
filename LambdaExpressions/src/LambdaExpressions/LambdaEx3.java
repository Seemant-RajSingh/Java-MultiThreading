package LambdaExpressions;

public class LambdaEx3 {

    static String s2 = "class static string";

    private String s3 = "class field string";

    public static void main(String[] args) {

        String s = "sample string"; // not updatable

        LambdaEx3 l = new LambdaEx3();

        MyInterface m1 = () -> {
            System.out.println(s + " HERE WITH " + s2 + " AND " + l.s3);
        };

//        s = "changed sample string";  // compilation error cause local variables used in lambda exp should be effectively final, this dosent apply to fields

        m1.printIt();
        l.s3 = "updated class field string";    // updatable
        s2 = "updated class static string"; // same with LambdaEx3.s2, this is allowed to change
        System.out.println(LambdaEx3.s2 + " - " + l.s3);

    }
}
