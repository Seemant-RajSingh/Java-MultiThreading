package SynchronizedBlocks;

public class MultipleMonitorObjects {

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    private int counter1 = 0;
    private int counter2 = 0;

    private void incCounter1(){
        synchronized (this.monitor1) {  // threads pointing to same this.monitor1 cant execute this block simultaneously
            this.counter1++;
        }
    }

    private void incCounter2(){
        synchronized (this.monitor2) { // threads pointing to same this.monitor2 cant execute this block simultaneously
            this.counter2++;
        }
    }
    // these two methods can be called simultaneously by threads of same instance (sync block will be accessed by one thread at a time ofco)
}
