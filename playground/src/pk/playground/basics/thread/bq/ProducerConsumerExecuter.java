package pk.playground.basics.thread.bq;


import pk.playground.model.Operation;
import pk.playground.model.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExecuter {
    private static BlockingQueue<Task> taskQueue = new ArrayBlockingQueue<>(4);

    public static void main(String[] args) {
        ExecutorService queueExecuter = Executors.newFixedThreadPool(5);
        queueExecuter.execute(new Thread((new Producer(taskQueue))));
        queueExecuter.execute(new Thread((new AdditionConsumer(taskQueue))));
        queueExecuter.execute(new Thread((new SubtractionConsumer(taskQueue))));
        queueExecuter.execute(new Thread((new MultiplicationConsumer(taskQueue))));
        queueExecuter.execute(new Thread((new DivisionConsumer(taskQueue))));

    }
}


class AdditionConsumer implements Runnable {
    private BlockingQueue<Task> operationQueue;

    public AdditionConsumer(BlockingQueue<Task> operationQueue) {
        this.operationQueue = operationQueue;
    }

    @Override
    public void run() {
        try {
            Task takenTask = null;
            while ((takenTask = operationQueue.take()).getOperand1() != 0) {
                if(Operation.ADD != takenTask.getOperation()){
                    System.out.println("Notifying others from AdditionConsumer");
                    notifyAll();
                }
                takenTask.execute();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class SubtractionConsumer implements Runnable {
    private BlockingQueue<Task> operationQueue;

    public SubtractionConsumer(BlockingQueue<Task> operationQueue) {
        this.operationQueue = operationQueue;
    }

    @Override
    public void run() {
        try {
            Task takenTask = null;
            while ((takenTask = operationQueue.take()).getOperand1() != 0) {
                if(Operation.SUB != takenTask.getOperation()){
                    System.out.println("Notifying others from SubtractionConsumer");
                    notifyAll();
                }
                takenTask.execute();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MultiplicationConsumer implements Runnable {
    private BlockingQueue<Task> operationQueue;

    public MultiplicationConsumer(BlockingQueue<Task> operationQueue) {
        this.operationQueue = operationQueue;
    }

    @Override
    public void run() {
        try {
            Task takenTask = null;
            while ((takenTask = operationQueue.take()).getOperand1() != 0) {
                if(Operation.MUL != takenTask.getOperation()){
                    System.out.println("Notifying others from MultiplicationConsumer");
                    notifyAll();
                }
                takenTask.execute();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DivisionConsumer implements Runnable {
    private BlockingQueue<Task> operationQueue;

    public DivisionConsumer(BlockingQueue<Task> operationQueue) {
        this.operationQueue = operationQueue;
    }

    @Override
    public void run() {
        try {
            Task takenTask = null;
            while ((takenTask = operationQueue.take()).getOperand1() != 0) {
                if(Operation.DIV != takenTask.getOperation()){
                    System.out.println("Notifying others from DivisionConsumer");
                    notifyAll();
                }
                takenTask.execute();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
