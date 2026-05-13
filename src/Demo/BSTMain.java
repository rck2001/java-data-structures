package Demo;

import tree.BinarySearchTree;

public class BSTMain {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(3);
        tree.insert(5);
        tree.insert(6);
        tree.insert(4);
        tree.insert(1);
        tree.insert(7);
        tree.insert(2);

        tree.remove(3);

        int a = 2;
        System.out.printf("Is %d present in the tree?: %b\n", a, tree.search(a));

        System.out.println(tree);
        System.out.println("Is the tree empty?: " + tree.isEmpty());
        System.out.println("Size: " + tree.size());
    }
}
