package Unidade_03;

public class Ex2 {

    static class BST extends BinaryTree {
        boolean isBST() {
            return isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isBST(Node node, int min, int max) {
            if (node == null) return true;
            if (node.value <= min || node.value >= max) return false;
            return isBST(node.left, min, node.value) && isBST(node.right, node.value, max);
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

        if (tree.isBST()) {
            System.out.println("A árvore é uma Árvore Binária de Busca (BST).");
        } else {
            System.out.println("A árvore não é uma Árvore Binária de Busca (BST).");
        }

    }

}