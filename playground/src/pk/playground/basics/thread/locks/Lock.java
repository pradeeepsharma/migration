package pk.playground.basics.thread.locks;

public class Lock /*implements AutoCloseable*/ {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            System.out.println("Lock seen by :" + Thread.currentThread().getName());
            wait();
        }
        isLocked = true;
        System.out.println("Lock accured by :" + Thread.currentThread().getName());
    }

    public void unLock() {
        System.out.println("Lock released by :" + Thread.currentThread().getName());
        if (isLocked) {
            isLocked = false;
            notify();
        }
    }

    /*@Override
    public void close(){
        isLocked = false;
    }*/
}
