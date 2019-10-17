package pk.playground.ds.custom;

public interface Tree {
    void add(int value);


    void inOrderTravesal();
}

class Node{
    private Integer value;
    private Node leftNode;
    private Node rightNode;
    Node(Integer value){
        this.value=value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}