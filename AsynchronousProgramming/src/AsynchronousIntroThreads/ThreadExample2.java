package AsynchronousIntroThreads;

public class ThreadExample2 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("thread started: " + threadName);
            System.out.println("thread finished: " + threadName);
        };

        Thread thread1 = new Thread(runnable);
        System.out.println("check1");
        thread1.start();
        Thread thread2 = new Thread(runnable, "custom name");
        System.out.println("check2");
        thread2.start();

        // * random order of threads starting ... up to CPU
    }
}
