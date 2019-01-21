package pk.playground.basics.thread.bq;

import pk.playground.model.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<Task> linkedBlockingQueue ;

    public Consumer(BlockingQueue linkedBlockingQueue) {
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    @Override
    public void run(){
        while(linkedBlockingQueue.isEmpty()){
            try {
                Task take = linkedBlockingQueue.take();
                take.execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
