package Unidade_01;

public class Ex5 {
    public static void main(String[] args) {

        int[][] matrix = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 1000);
            }
        }


        // print the matrix as matrix
        System.out.println("Matriz 3x3:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
            
        // esse MIN_VALUE é rebuscado
        int largestNumber = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] > largestNumber){
                    largestNumber = matrix[i][j];
                }
            }
        }

        System.out.println("O maior número da matriz é: " + largestNumber);
    }
}