package SynchronizedBlocks;

public class SynchronizedExchanger {

    protected Object object;


    public synchronized void setObject(Object o) {
        this.object = o;
    }

    public synchronized Object getObject() {
        return this.object;
    }

    public void setObj(Object o) {
        synchronized (this) { this.object = o; }    // synced on instance
    }

    public Object getObj() {    // synced on this(instance) implicitly since the method is not static
        synchronized (this) { return this.object; } // two threads of the same instance cant enter this block simultaneously
    }

    public static void main(String[] args) {
        System.out.println("entered");

        SynchronizedExchanger exchanger = new SynchronizedExchanger();

        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<1000; i++) {
                            exchanger.setObject("" + i);    // thread handling object
                        }
                    }
                }
        );

        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<1000; i++) {
                            System.out.println(exchanger.getObject());  // gives a bunch of nulls first then skipping numbers to 999 cause thread scheduling order
                        }
                    }
                }
        );

        thread1.start();
        thread2.start();

        System.out.println("ending");
    }

}

// class o/p: randomly sets and gets the values

// synchronized - methods, blocks (on)