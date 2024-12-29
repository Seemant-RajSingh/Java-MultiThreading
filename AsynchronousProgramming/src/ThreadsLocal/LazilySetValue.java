package ThreadsLocal;

public class LazilySetValue {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        String value = threadLocal.get();

        if(value == null) {
            threadLocal.set("lazily set value");    // lazily set threadlocal value (on main thread?)
            value = threadLocal.get();
        }

        System.out.println(value);
    }
}

// useful when there are values which come from context out in the code which cant be determined until thread is ready to call the threadlocal
