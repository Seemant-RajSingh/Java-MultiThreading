package SynchronizedBlocks;

public class Reentrance {

    private int count = 0;

    public synchronized void inc() {
        this.count++;
    }

    public synchronized int incAndGet() {
        inc();
        return this.count;
    }
}

//context: both funcs are imlicitly sync locked on instance, so a thread of an instance executing incAndGet can call inc()


