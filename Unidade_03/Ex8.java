package Unidade_03;

public class Ex8 {

    static class BST extends BinaryTree {

        int findMin() {
            return findMin(this.root);
        }

        int findMin(Node node) {
            return node.left == null ? node.value : findMin(node.left);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);


        int min = tree.findMin();
        System.out.println("O menor valor na árvore é: " + min);

    }

}