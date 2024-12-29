package LambdaExpressions;

public interface MyFunc {

    public String apply(String text1, String text2);

}

// since java 8, interfaces can have default and static methods, only the abstract one by deafault is implemented by lambda expressions