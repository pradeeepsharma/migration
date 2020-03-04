package pk.playground.basics.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Stack {
    private List<Node> nodeStack = new ArrayList<>();
    private AtomicInteger currentIndex = new AtomicInteger(0);

    public boolean push(Node node){
        nodeStack.add(currentIndex.getAndSet(currentIndex.intValue()+1),node);
        return true;
    }

    public Node pop(){
        if(currentIndex.get()==0){
            return null;
        }
       return nodeStack.remove(currentIndex.getAndSet(currentIndex.intValue()-1));
    }
}
