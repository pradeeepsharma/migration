package pk.playground.ds.custom;

import org.junit.jupiter.api.Test;

public class BSTreeTest {

    @Test
    public void canGetTreeInOrder(){
        Tree newTree = new BSTree();
        newTree.add(16);
        newTree.add(19);
        newTree.add(22);
        newTree.add(15);
        newTree.add(24);
        newTree.add(12);
    newTree.inOrderTravesal();
    }
}
