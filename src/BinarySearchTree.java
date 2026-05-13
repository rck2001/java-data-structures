public class BinarySearchTree {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // initial tree
    private Node root = null;
    private int size = 0;

    // insert and remove methods
    public void insert(int data) {
        if(search(data)) return; // duplicates not allowed

        Node newNode = new Node(data);
        root = insertHelper(root, newNode);
        size++;
    }
    public boolean remove(int data) {
        int initialSize = size;
        root = removeHelper(root, data);
        return size < initialSize;
    }

    // display methods
    @Override
    public String toString() {
        if(isEmpty()) {
            return "Empty tree";
        }

        StringBuilder sb = new StringBuilder();
        displayHelper(root, sb);

        return sb.toString();
    }

    // utility methods
    public boolean isEmpty() {
        return root == null;
    }
    public int size() {
        return size;
    }
    public boolean search(int data) {
        return searchHelper(root, data);
    }

    // helper methods
    private Node insertHelper(Node root, Node node) {
        if(root == null) {
            return node;
        }

        if(node.data < root.data) {
            root.left = insertHelper(root.left, node);
        }
        else if(node.data > root.data) {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }
    private void displayHelper(Node root, StringBuilder sb) {

        if(root != null) {
            displayHelper(root.left, sb);
            sb.append(root.data).append("\n");
            displayHelper(root.right, sb);
        }
    }
    private boolean searchHelper(Node root, int data) {

        if(root == null) return false; // empty tree

        if(data == root.data) {
            return true;
        }
        if(data < root.data) {
            return searchHelper(root.left, data);
        }
        else {
            return searchHelper(root.right, data);
        }
    }

    private Node removeHelper(Node root, int data) {

        // base case
        if(root == null) return null;

        if(data < root.data) { // search the left branch
            root.left = removeHelper(root.left, data);
        }
        else if(data > root.data) { // search the right branch
            root.right = removeHelper(root.right, data);
        }
        else { // data found at current root
            // case 1: leaf node
            if(root.left == null && root.right == null) {
                size--;
                return null;
            }
            // case 2: right child
            else if(root.left == null) {
                size--;
                return root.right;
            }
            // case 3: left child
            else if(root.right == null) {
                size--;
                return root.left;
            }
            // case 4: two children
            else {
                int successorValue = successor(root.right);
                root.data = successorValue;
                root.right = removeHelper(root.right, successorValue);
            }
        }

        return root;
    }
    private int successor(Node root) {
        while(root.left != null) {
            root = root.left;
        }

        return root.data;
    }
}
