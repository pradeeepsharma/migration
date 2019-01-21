package pk.playground.basics.thread.bq;

import pk.playground.basics.thread.executer.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {
    public static void main(String[] args) {
        BlockingQueue<Task> taskQueue = new ArrayBlockingQueue<>(5);
        Producer taskProducer = new Producer(taskQueue);
        Consumer taskConsumer = new Consumer(taskQueue);
        Thread producerThread = new Thread(taskProducer);
        Thread consumerThread = new Thread(taskConsumer);
        producerThread.start();
        consumerThread.start();


    }
}
