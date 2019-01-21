package pk.playground.basics.thread.executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecuter {
    public static void main(String[] args) {
        ExecuterService executerService = new ExecuterService();
        executerService.execute(new Task(new Counter(1)));
        executerService.execute(new Task(new Counter(2)));
        executerService.execute(new Task(new Counter(3)));
    }




}

class ExecuterService{
    private ExecutorService singeThreadExecuter = Executors.newSingleThreadExecutor();

    public void execute(Runnable task){
        singeThreadExecuter.execute(task);
    }
}