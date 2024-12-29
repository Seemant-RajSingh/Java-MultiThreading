package MemoryModel;

public class MemoryModelExample {

    // this class must be static ... why?
    public static class MyRunnable implements Runnable {
        private int count = 0;  // each thread created using this class will have a count field
//        private MyRunnable mr = new MyRunnable();   // so threads can share fields

        @Override
        public void run() {
            MyRunnable mr = new MyRunnable(); // sample object created by each thread => each thread hold reference myObj in Thread stack pointing to separate MyObj object in heap
            System.out.println(mr);

            for(int i=0; i<1000000; i++) {   // each thread will in all cases have their own i (local var)
                synchronized (this ) {this.count++;}
            }
            System.out.println(
                    Thread.currentThread().getName()
                    + " : " + this.count
            );
        }
    }

    public static void main(String[] args) {

        // each thread has its own count field
        Runnable runnable1 = new MyRunnable();
//        Runnable runnable2 = new MyRunnable();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(new MyRunnable()); // alternate, separate count var for this

        thread1.start();    // created using method 3
        thread2.start();    // independent count field, cause points to different MyRunnable reference

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Thread thread3 = new Thread(runnable1); // now thread3 and thread1 share the same MyRunnable reference and hence the count
        thread3.start();    // might start before thread1 and get final count value 10

    }
}

// o/p:
//MemoryModel.MemoryModelExample$MyRunnable@6bd00163
//MemoryModel.MemoryModelExample$MyRunnable@4c1e163f
//MemoryModel.MemoryModelExample$MyRunnable@7ce3624
//Thread-2 : 20
//Thread-0 : 10
//Thread-1 : 10



// *** FOR LARGER VALUES (count to 1000000):
//Thread-2 : 1824412
//Thread-0 : 1053697
//Thread-1 : 1000000    this is because both threads start simultaneously and overwrite each other's count var (shared)
//to solve use:
//        for(int i=0; i<1000000; i++) {   // each thread will in all cases have their own i (local var)
//            synchronized (this) this.count++;
//        }
// updated o/p on synchronize block:
//Thread-1 : 1000000
//Thread-0 : 1941438    // check why not 1000000
//Thread-2 : 2000000