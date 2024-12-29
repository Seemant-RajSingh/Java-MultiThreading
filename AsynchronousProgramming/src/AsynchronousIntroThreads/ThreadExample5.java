package AsynchronousIntroThreads;

// make other threads wait for selected thread to finish
public class ThreadExample5 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("inside runnable override");
            for(int i=0; i<10; i++) {
                sleep(1000);
                System.out.println("created thread looping");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        for(int i=0; i<5; i++) {
            sleep(1000);
            System.out.println("main thread looping");  // runs side by side
        }

        try {
            System.out.println("here");
            thread.join();  // main thread gets blocked until thread terminates .. else thread dosent get a chance to execute as main thread immediately finishes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
