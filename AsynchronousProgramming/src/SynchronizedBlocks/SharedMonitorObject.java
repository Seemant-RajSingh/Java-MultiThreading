package SynchronizedBlocks;

public class SharedMonitorObject {

    private Object monitor = null;

    private int counter = 0;

    // constructor
    public SharedMonitorObject(Object monitor) throws IllegalAccessException {
        if(monitor == null) {
            throw new IllegalAccessException(
                    "Monitor object cannot be null"
            );
        }
        this.monitor = monitor;
    }

    public void inCounter() {
        synchronized (this.monitor) {   // ** synchronized ON this.monitor ... threads with same this.monitor will block each other
            this.counter++;
        }
    }


    public static void main(String[] args) throws IllegalAccessException {
        Object monitor1 = new Object();

        SharedMonitorObject smo1 = new SharedMonitorObject(monitor1);
        SharedMonitorObject smo2 = new SharedMonitorObject(monitor1);

        smo1.inCounter();   // instances not thread <-
        smo2.inCounter();


        Object monitor2 = new Object();

        SharedMonitorObject smo3 = new SharedMonitorObject(monitor2);

        smo3.inCounter();
    }
}
