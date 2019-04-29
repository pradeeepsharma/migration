package pk.playground.basics.thread.bq;


import pk.playground.model.Operation;
import pk.playground.model.Task;

import java.util.concurrent.*;

public class ProducerConsumerExecuter {
    private static LinkedBlockingDeque<Task> taskDeQueue = new LinkedBlockingDeque<>(4);

    public static void main(String[] args) {
        ExecutorService queueExecuter = Executors.newFixedThreadPool(5);
        queueExecuter.execute(new Thread((new Producer(taskDeQueue))));
        queueExecuter.execute(new Thread((new AdditionConsumer(taskDeQueue))));
        queueExecuter.execute(new Thread((new SubtractionConsumer(taskDeQueue))));
        queueExecuter.execute(new Thread((new MultiplicationConsumer(taskDeQueue))));
        queueExecuter.execute(new Thread((new DivisionConsumer(taskDeQueue))));

    }
}


class AdditionConsumer implements Runnable {
    private LinkedBlockingDeque<Task> operationQueue;

    public AdditionConsumer(LinkedBlockingDeque<Task> operationQueue) {
        this.operationQueue = operationQueue;
    }

    @Override
    public void run() {
        try {
            Task takenTask = null;
            while ((takenTask = operationQueue.take()).getOperand1() != 0) {
                if(Operation.ADD != takenTask.getOperation()){
                    operationQueue.push(takenTask);
                    System.out.println("Pushed back to queue :"+operationQueue.size());
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
    private LinkedBlockingDeque<Task> operationQueue;

    public SubtractionConsumer(LinkedBlockingDeque<Task> operationQueue) {
        this.operationQueue = operationQueue;
    }

    @Override
    public void run() {
        try {
            Task takenTask = null;
            while ((takenTask = operationQueue.take()).getOperand1() != 0) {
                if(Operation.SUB != takenTask.getOperation()){
                    System.out.println("Pushed back to queue :"+operationQueue.size());
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
    private LinkedBlockingDeque<Task> operationQueue;

    public MultiplicationConsumer(LinkedBlockingDeque<Task> operationQueue) {
        this.operationQueue = operationQueue;
    }

    @Override
    public void run() {
        try {
            Task takenTask = null;
            while ((takenTask = operationQueue.take()).getOperand1() != 0) {
                if(Operation.MUL != takenTask.getOperation()){
                    System.out.println("Pushed back to queue :"+operationQueue.size());
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
    private LinkedBlockingDeque<Task> operationQueue;

    public DivisionConsumer(LinkedBlockingDeque<Task> operationQueue) {
        this.operationQueue = operationQueue;
    }

    @Override
    public void run() {
        try {
            Task takenTask = null;
            while ((takenTask = operationQueue.take()).getOperand1() != 0) {
                if(Operation.DIV != takenTask.getOperation()){
                    System.out.println("Pushed back to queue :"+operationQueue.size());
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
