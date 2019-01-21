package pk.playground.basics.thread.bq;

import pk.playground.model.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<Task> linkedBlockingQueue;

    public Consumer(BlockingQueue linkedBlockingQueue) {
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    @Override
    public void run() {
        try {
            Task takenTask = null;
            while ((takenTask = linkedBlockingQueue.take()).getOperand1() != 0) {
                    takenTask.execute();
                //  Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
