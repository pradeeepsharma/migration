package pk.playground.ds.custom;

public class BSTree implements Tree {
    private Node root;

    BSTree() {
        // root = new Node(null);
    }

    @Override
    public void add(int value) {

       root =  insert(value, root);
    }

    private Node insert(int value, Node rootNode) {
        if (rootNode == null) {
            rootNode = new Node(value);
        } else if (rootNode.getValue() < value) {
            rootNode.setRightNode(insert(value, rootNode.getRightNode()));
        } else {
            rootNode.setLeftNode(insert(value, rootNode.getLeftNode()));
        }
        return rootNode;
    }

    @Override
    public void inOrderTravesal() {

        printInOrder(root);

    }

    private void printInOrder(Node rootNode) {
        if (rootNode != null) {
            printInOrder(rootNode.getLeftNode());
            System.out.println(rootNode.getValue());
            printInOrder(rootNode.getRightNode());
        }
    }

}
