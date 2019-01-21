package pk.playground.basics.thread.executer;

public class Task implements Runnable{
private Counter counter;
public Task(Counter counter){
    this.counter = counter;
}
    @Override
    public void run(){
        System.out.println("Increasing counter from Thread :"+Thread.currentThread().getName());
        counter.increase();
    }
}
