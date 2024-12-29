package VirtualThreads;

public class VirtualThreadExample {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for(int i=0; i<10; i++) {
                System.out.println("Index: " + i);
            }
        };

        Thread vThread = Thread.ofVirtual().start(runnable);    // create and start a virtual thread

        Thread vThreadUnstarted = Thread.ofVirtual().unstarted(runnable);   // create virtual thread

        vThreadUnstarted.start();

        try {
            vThreadUnstarted.join();    // else main finishes before thread executes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// can create a lot more virtual threads than platform threads