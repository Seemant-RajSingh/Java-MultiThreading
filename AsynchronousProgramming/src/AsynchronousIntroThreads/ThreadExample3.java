package AsynchronousIntroThreads;

public class ThreadExample3 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override   // better use lambda to override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println("thread started: " + threadName);

                try {   // created thread runs
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread finished: " + threadName);   // prints even if 'end' is printed
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("end");
    }
}
