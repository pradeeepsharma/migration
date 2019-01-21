package pk.playground.basics.thread.executer;

public class Counter{
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public void increase(){
        value++;
    }
    public int getCurrentValue(){
        return value;
    }

}
