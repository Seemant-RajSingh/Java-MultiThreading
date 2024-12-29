package VirtualThreads;

import java.util.ArrayList;
import java.util.List;

public class ManyVirtualThreadsExample {

    public static void main(String[] args) {
        List<Thread> vThreads = new ArrayList<>();

        int vThreadCount = 5;   // 100000 works just fine

        // creating vthreads and adding to list - method 4
        // virtual threads don't necessarily execute in the order we start them in code
        for(int i=0; i<vThreadCount; i++) {
            int vThreadIndex = i;

            //
            Thread vThread = Thread.ofVirtual().start(() -> {
                // some custom run function logic
                System.out.println("vthread execution started");
//                System.out.println(vThreadIndex);
                for(int j=0; j<10; j++) {
                    sleep(2000);
                    System.out.println(j + ": " + vThreadIndex);
                }
            });

            vThreads.add(vThread);
        }

        // joining all threads to main, so they all execute before main resumes/finishes
        // main stops at i=0 itself until i=0 thread finishes
        for (int i=0; i<vThreads.size(); i++) {
            try {
                vThreads.get(i).join();
                System.out.println("here"); // changing order of these two lines change o/p
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
