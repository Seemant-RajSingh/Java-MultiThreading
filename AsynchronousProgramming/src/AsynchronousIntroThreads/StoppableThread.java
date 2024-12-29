package AsynchronousIntroThreads;

// implementing a runnable that can be stopped, similar to method 3
public class StoppableThread {

    public static class StoppableRunnable implements Runnable {

        private boolean stopRequested = false;

        public synchronized void requestStop() {
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested() {
            return this.stopRequested;
        }


        // sleep
        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println("stoppableRunnable running");
            while (! isStopRequested()) {   // keep doing something until stop requested
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("stoppableRunnable stopped");
        }
    }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread (stoppableRunnable, "sr thread (custom name)");
        thread.start();

        try {
            Thread.sleep(5000); // main thread sleeps, stoppablerunnable thread running in while loop
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("stop requested");
    }
}
