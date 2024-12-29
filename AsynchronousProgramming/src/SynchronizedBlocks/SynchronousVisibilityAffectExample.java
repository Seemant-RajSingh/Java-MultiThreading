package SynchronizedBlocks;

public class SynchronousVisibilityAffectExample {

    private long count = 0;

    public synchronized void incCount() {
        this.count++;
    }

    public synchronized long getCount() {
        return this.count;
    }

    public static void main(String[] args) {
        SynchronousVisibilityAffectExample s = new SynchronousVisibilityAffectExample();

        Thread thread1 = new Thread( () -> {    // method 4, overriding runnable interface run func
            for(int i=0; i<10000; i++) {
                s.incCount();
            }
            System.out.println(s.getCount());
        });

        Thread thread2 = new Thread( () -> {    // method 4, overriding runnable interface run func
            for(int i=0; i<10000; i++) {
                s.incCount();
            }
            System.out.println(s.getCount());
        });

        thread1.start();
        thread2.start();
    }
}

// ** works fine without synchronized methods till i-1000