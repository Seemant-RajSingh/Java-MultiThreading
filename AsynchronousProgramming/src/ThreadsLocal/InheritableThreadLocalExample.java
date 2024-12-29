package ThreadsLocal;

public class InheritableThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            System.out.println("---thread 1---");
            threadLocal.set("thread 1 - threadLocal value");
            inheritableThreadLocal.set("thread 1 - inheritable Thread local value");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() ->{
                System.out.println("---child thread---");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });
            childThread.start();
        });

        Thread thread2 = new Thread(() -> {

            try {   // better to pause thread here
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("---thread 2---");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        });

        thread1.start();

//        try {
//            thread2.join();
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        thread2.start();
    }
}

// o/p:
//---thread 1---
//thread 1 - threadLocal value .. can see both
//thread 1 - inheritable Thread local value
//---child thread---
//        null
//thread 1 - inheritable Thread local value ... child can see inhertable thread local value
//---thread 2---
//        null .. cant see none
//        null