package AsynchronousIntroThreads;

// stop selected threads when main thread is finished
public class ThreadEaxmple4 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("thread started");
            while (true) {
                sleep(1000);
                System.out.println("non-main thread running");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true); // without this the thread keeps running even when main thread is finished
        thread.start();
        sleep(3100);
        System.out.println("end");

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
