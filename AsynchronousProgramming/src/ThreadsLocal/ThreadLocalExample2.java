package ThreadsLocal;

public class ThreadLocalExample2 {

    public static void main(String[] args) {
        // alternate I :  for threadLocal1.set() .. this function .. sets object instance in thread local for each thread
        ThreadLocal<Object> threadLocal1 = new ThreadLocal<Object>() {  // overriding using anonymous class
            @Override
            protected Object initialValue() {
                return new Object();
            }
        };  // overrides regular class method (usual syntax? - yes)

        // altername II : for threadLocal2.set() .. this function .. sets object instance in thread local for each thread
        ThreadLocal<Object> threadLocal2 = ThreadLocal.withInitial(() -> {  // overriding Supplier functional interface (parameter for withInitial method), // directly calling a function at instance initialization? - NO ... STATIC METHOD
            return new Object();
        });

        Thread thread1 = new Thread(() -> {
            System.out.println("threadLocal1: " + threadLocal1.get());
            System.out.println("threadLocal2: " + threadLocal2.get());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("threadLocal1: " + threadLocal1.get());
            System.out.println("threadLocal2: " + threadLocal2.get());
        });

        thread1.start();
        thread2.start();
    }
}
