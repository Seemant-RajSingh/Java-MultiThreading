package LambdaExpressions;

import java.util.Comparator;

public class LambdaEx1 {

    public static void main(String[] args) {
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {  // default name of function in func interface
                return o1.compareTo(o2); // standard way of comparing strings
            }
        };

        int comparisionOp = stringComparator.compare("abc", "def");
        System.out.println(comparisionOp);  // negative



//        Comparator<String> stringComparatorLambda = (String o1, String o2) -> {   // no need to specify param type, referred from interface
//            return o1.compareTo(o2);
//        };

        Comparator<String> stringComparatorLambda = (o1, o2) -> o1.compareTo(o2);   // simplified version

        int comparisionOpLamnda = stringComparatorLambda.compare("abc", "abc"); // 0
        System.out.println(comparisionOpLamnda);

        //--------------------
        MyFunc mf1 = (s1, s2) -> {
            return s1 + " " + s2;
        };

        System.out.println(mf1.apply("hey", "there"));;

        MyFunc mf2 = mf1;   // * referencing the same lambda object
        System.out.println(mf2.apply("hey there", "again"));
    }


}

// can create custom interfaces and use ... returning void/other datatypes