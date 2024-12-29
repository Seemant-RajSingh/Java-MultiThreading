package SynchronizedBlocks;

public class SynchronizedSelf2 implements Runnable {
    private long count = 0;

    public synchronized void incCount() {
        this.count++;
    }

    public synchronized long getCount() {
        return this.count;
    }

    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            this.incCount();
        }
        System.out.println(this.getCount());
    }

    public static void main(String[] args) {
        SynchronizedSelf2 s = new SynchronizedSelf2();

        Thread thread1 = new Thread(s);
        Thread thread2 = new Thread(s);

        thread1.start();
        thread2.start();
    }
}

// print thread names and check why this not 10000: 11661 <-
//20000
// solution:
//@Override
//public void run() {
//    synchronized (this) {
//        for(int i=0; i<10000; i++) {
//            this.incCount();
//        }
//        System.out.println(this.getCount());
//    }
//}