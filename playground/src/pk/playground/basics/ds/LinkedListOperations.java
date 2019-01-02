package pk.playground.basics.ds;


public class LinkedListOperations{
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int i=0;i<=100;i++){
            linkedList.insert(i);
        }
        linkedList.print();
        System.out.println();
        System.out.println("Mid of the list :"+linkedList.midOfTheList());
    }
}
class LinkedList {
    Node headNode;

    public void insert(int newValue){
        Node newNode = new Node(newValue);
            newNode.next = headNode;
            headNode = newNode;

    }
    public void print(){
        Node currenNode = headNode;
        while(currenNode!=null){
            System.out.print(currenNode.value+"->");
            currenNode = currenNode.next;
        }
    }

    public int midOfTheList(){
        Node fastPointer = headNode;
        Node slowPointer = headNode;
        while(fastPointer!=null && fastPointer.next!=null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            //System.out.println("Fast POinter :"+fastPointer.value+" Slow pointer :"+slowPointer.value);
        }
        return slowPointer.value;
    }
}

class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
        this.next=null;
    }
}