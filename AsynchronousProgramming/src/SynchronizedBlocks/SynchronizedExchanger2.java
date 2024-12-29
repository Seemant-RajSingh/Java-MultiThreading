package SynchronizedBlocks;

public class SynchronizedExchanger2 {

    protected static Object object = null;

    public static synchronized void setObject(Object o) {
//        this.object = o;  // doesn't work cause setObject now static
        object = o;
    }

    public static synchronized Object getObject() {
        return object;
    }

    public static void setObj(Object o) {
        synchronized (SynchronizedExchanger2.class) { object = o; } // not synchronized method, synced on class, similar effect as synchronizing the whole method
    }

    public static Object getObj() {
        synchronized (SynchronizedExchanger2.class) { return object; }  // no two threads can access this code at the same time
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

// only one thread can call any of these
// same res as ex. 1
