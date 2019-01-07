package pk.playground.basics.thread;

import pk.playground.basics.thread.locks.Lock;

public class CounterWithLock {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> incrementer(counter));
        Thread t2 = new Thread(() -> incrementer(counter));
        Thread t3 = new Thread(() -> incrementer(counter));
        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");
        t1.start();
        t2.start();
        t3.start();
    }

    public static void incrementer(Counter counter){
        System.out.println("Counter value :"+counter.getValule()+" for thread :"+Thread.currentThread().getName());
        counter.increase();
    }
}

class Counter {
    private Lock lock = new Lock();
    int counter = 0;

    public int increase() {
        try {
            lock.lock();
            counter++;
            lock.unLock();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            System.out.println("Closing all threads");
        }
        return counter;
    }

    public int getValule(){
        return counter;
    }
}
