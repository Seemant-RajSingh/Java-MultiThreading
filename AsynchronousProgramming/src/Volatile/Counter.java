package Volatile;

public class Counter {

    private volatile int count = 0;
    // or make count atomic integer

    public boolean inc() {
        if(this.count == 10) {
            return false;
        }
        this.count++;   // this step is not atomic : read-increment-write, if both threads read it at the same time then error cause both will update 10 which is not supposed to happen
        return true;
        // better to synchronize?
    }
}

// using volatile - performance penalty - only use when necessary (find when), don't use on single threaded apps
// volatile fields - visibility guarantee on reordering code


// package name - volatile => option to create kotlin class, Volatile => "" "" java classes