package pk.playground.basics.thread;

import pk.playground.basics.thread.locks.Lock;

public class CounterWithLock {
    public static void main(String[] args) {
        Counter counter = new Counter();
       /* for(int i=0;i<100;i++){
            Thread thread = new Thread(() -> incrementer(counter));
            thread.setName("T"+i);
            thread.start();
        }*/
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

    public static void incrementer(Counter counter) {
        System.out.println("Counter value :" + counter.getValule() + " for thread :" + Thread.currentThread().getName());
        counter.increase();
    }
}

class Counter {
    private Lock lock = new Lock();
    int counter = 0;

    public int increase() {
         try {
            lock.lock();
            for (int i = 1; i <= 10; i++){
                counter++;
            }
            lock.unLock();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return counter;
    }

    public int getValule() {
        return counter;
    }
}
