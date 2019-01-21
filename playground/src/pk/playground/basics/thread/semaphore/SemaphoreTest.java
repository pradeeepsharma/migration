package pk.playground.basics.thread.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        Messanger sharedMessanger = new Messanger();
        Semaphore semaphore = new Semaphore(1/*, true*/);
        Thread t1 = new Thread(){
            @Override
            public void run(){
                this.setName("T1");
                try {
                    semaphore.acquire();
                    sharedMessanger.sayHi(this.getName());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                this.setName("T2");
                sharedMessanger.sayHello(this.getName());
            }
        };
        t1.start();
        t2.start();

        t2.join();
        t1.join();

    }

}

class Messanger {
    public void sayHi(String nameOfTheCallingThread) {
        System.out.println("Hi from :" + nameOfTheCallingThread);
    }

    public void sayHello(String nameOfTheCallingThread) {
        System.out.println("Hello from :" + nameOfTheCallingThread);
    }
}