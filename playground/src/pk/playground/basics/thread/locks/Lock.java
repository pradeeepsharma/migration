package pk.playground.basics.thread.locks;

public class Lock implements AutoCloseable{
    private boolean isLocked = false;

    public void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public void unLock(){
        isLocked = false;
        notify();
    }

    @Override
    public void close(){
        isLocked = false;
    }
}
