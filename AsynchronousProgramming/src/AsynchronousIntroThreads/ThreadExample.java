package AsynchronousIntroThreads;

public class ThreadExample {

    // method 2 to specify which code java thread should execute - extend Thread class and override run method
    public static class MyThread extends Thread {   // no @Override? - cause not implemented, extended?
        public void run() { // runnable method
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }
    }

    // method 3 to specify which code java thread should execute
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("runnable running");
            System.out.println("runnable finished");
        }
    }

    public static void main(String[] args) {

        // method 1 to specify which code java thread should execute - by instance of a class implementing Runnable functional interface
        Thread thread = new Thread();
        String threadname = Thread.currentThread().getName();
        System.out.println("-----" + threadname + " : " + Thread.currentThread());
        thread.start(); // executes default run method?

        // ----------------------------------
        // method 2 (not recommended)
        MyThread thread2 = new MyThread();
        String thread2name = Thread.currentThread().getName();
        System.out.println("-----" + thread2name + " : " + Thread.currentThread());
        thread2.start();  // thread started, executes run method on start

        // ----------------------------------
        // method 3
        Thread thread3 = new Thread(new MyRunnable());  // may create separate instances but run func is same for all threads for this class
        String thread3name = Thread.currentThread().getName();
        System.out.println("-----" + thread3name + " : " + Thread.currentThread());
        thread3.start();

        //-----------------------------------
        // method 4
        Runnable runnable = () -> { // anonymous object, separate run func for each thread
            String threadName = Thread.currentThread().getName();
            System.out.println("lambda thread running with name: " + threadName );  // custom name
            System.out.println("lambda thread finished");
        };

        Thread thread4 = new Thread(runnable, "custom name");

//        String thread4name = Thread.currentThread().getName();
//        System.out.println("-----" + thread4name + " : " + Thread.currentThread()); // -----main : Thread[main,5,main]

        thread4.start();

//        String thread4name = Thread.currentThread().getName();
//        System.out.println("-----" + thread4name + " : " + Thread.currentThread()); // blank o/p
    }
}


// There are two ways to start a new Thread – Subclass Thread and implement Runnable
// Threads might take 1-2MB of stack space - java's project LOOM - fibres Java 14 (light weight threads managed by JVM)