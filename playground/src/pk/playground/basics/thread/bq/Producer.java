package pk.playground.basics.thread.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import pk.playground.model.File;
import pk.playground.model.Operation;
import pk.playground.model.Task;

public class Producer implements Runnable {
    BlockingQueue<Task> linkedBlockingQueue;

    public Producer(BlockingQueue linkedBlockingQueue) {
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 5; i++) {
                int operand1 = i + 10;
                int operand2 = i + 9;
                Task addTask = new Task(operand1, operand2, Operation.ADD);
                Task subtractTask = new Task(operand1, operand2, Operation.SUB);
                Task multiplyTask = new Task(operand1, operand2, Operation.MUL);
                Task divideTask = new Task(operand1, operand2, Operation.DIV);

                System.out.println("Producing Task for adding :" + operand1 + " and :" + operand2);
                linkedBlockingQueue.put(addTask);
               // Thread.sleep(100);
                System.out.println("Producing Task for subtracting :" + operand1 + " and :" + operand2);
                linkedBlockingQueue.put(subtractTask);
                //Thread.sleep(100);
                System.out.println("Producing Task for multiplying :" + operand1 + " and :" + operand2);
                linkedBlockingQueue.put(multiplyTask);
                //Thread.sleep(100);
                System.out.println("Producing Task for dividing :" + operand1 + " and :" + operand2);
                linkedBlockingQueue.put(divideTask);
                //Thread.sleep(100);

            }
            linkedBlockingQueue.put(new Task(0, 0, Operation.DIV));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
