package pk.playground.basics.thread.executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecuter {
    private ExecutorService singeThreadExecuter = Executors.newFixedThreadPool(10);
}
