package SynchronizedBlocks;

import java.util.function.Consumer;

public class SynchronizedLambda {

    private static Object object = null;

    public static synchronized void setObject(Object o) {   // synchronized by default on class
        object = o;
    }

    public static void consumeObject(Consumer consumer) {
        consumer.accept(object);    // ** already overridden in param? - true ... and called right after
    }

    public static void sampleFunc() {
        System.out.println("sample text");
    }

    public static void main(String[] args) {
        consumeObject( (obj) -> {   // overriding accept method of functional interface Consumer
            synchronized (SynchronizedLambda.class) {
                System.out.println(obj);
            }
        });

        consumeObject( (obj) -> {
            synchronized (String.class) {   // doesn't make sense to have this monitor object cause now this and setObject are synchronized on diff monitor object for this function - thread calling setObject will not block a thread calling consumerObject => error-prone
                System.out.println(obj);
            }
        });

//        consumeObject( (obj) -> {
//            synchronized (this) {   //  there is no this in the context of lambda expression (for static only?)... compilation error
//                System.out.println(obj);
//            }
//        });

        sampleFunc();   // works
    }
}
