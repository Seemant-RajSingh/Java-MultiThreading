package SynchronizedBlocks;

// works as expected
public class SynchronizedSelf implements Runnable {

    // threads belonging to same instance cant access simultaneously
    // threads belonging to diff instance can access simultaneously
    public synchronized void f1() { // without sync its mixed thread-1 and 0
        for(int i=0; i<1000; i++) {
            System.out.println(Thread.currentThread().getName() + " : instance synced f1");
        }
    }

    // no 2 threads from same class can access this simultaneously
    public static synchronized void f2() {
        System.out.println(Thread.currentThread().getName() + " : static synced f2");
    }


    @Override
    public void run() {
        f1();
        System.out.println("-----------------------------------------------------------------");
        f2();
    }



    public static void main(String[] args) {
        SynchronizedSelf s1 = new SynchronizedSelf();
        SynchronizedSelf s2 = new SynchronizedSelf();
        SynchronizedSelf s3 = new SynchronizedSelf();

        Thread thread1 = new Thread(s1);
        Thread thread2 = new Thread(s1);
        Thread thread3 = new Thread(s2);

        thread1.start();
        thread2.start();
        thread3.start(); // works as expected
    }
}


//TERMS:
//monitor object - inside () of synchronized
// monitor object same as lambda objects?


// java synchronized visibility guarantee - the way synchronized blocks effect how diff threads reading/writing same data