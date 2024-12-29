package SynchronizedBlocks;

public class MixedSynchronization {

    public static Object staticObj = null;

    // method synchronized locked on class object cause static method
    public static synchronized void setStaticObj(Object obj) {
        staticObj = obj;
    }

    public Object instanceObj = null;

    // method synchronized on class instance locked on this(instance) implicitly
    public synchronized void setInstanceObj(Object obj) {
        this.instanceObj = obj;
    }   // threads created by instance of this class will block each other for this method
}
