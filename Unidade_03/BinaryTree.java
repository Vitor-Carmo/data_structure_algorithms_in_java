package Unidade_03;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}


class BinaryTree {
    Node root;

    Node insert(int value) {
        root = insert(root, value);
        return root;
    }
    
    private Node insert(Node node, int value) {
        if(node == null) return new Node(value);
        
        if(value < node.value) node.left = insert(node.left, value);
        else if(value > node.value) node.right = insert(node.right, value);
        return node; 
    }

    void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.value + " ");
        }
    }
    
}
