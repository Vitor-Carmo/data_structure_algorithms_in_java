package Unidade_03;

public class Ex1 {

    /* 
        10
       /  \
      5    15
     / \   /
    3   7 12
    */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);

        System.out.println("Percorrendo em Pré-Ordem:");
        tree.preOrder();

        System.out.println("Percorrendo em Pós-Ordem:");
        tree.postOrder();

        System.out.println("Percorrendo em Em-Ordem:");
        tree.inOrder();

    }

}