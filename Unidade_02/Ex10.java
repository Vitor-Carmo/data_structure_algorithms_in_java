package Unidade_02;

import java.util.ArrayList;

public class Ex10 {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(7);
        arr.add(2);
        arr.add(9);
        arr.add(1);
        arr.add(5);
        arr.add(7);

        System.out.println("Array Desordenado: " + arr);

        quickSort(arr, 0, arr.size() - 1);

        System.out.println("Array Ordenado: " + arr);
    }

    private static void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low >= high)
            return;

        int pivot_index = partition(arr, low, high);
        quickSort(arr, low, pivot_index - 1);
        quickSort(arr, pivot_index + 1, high);

    }

    private static int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) > pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(ArrayList<Integer> arr, int a, int b) {
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }
}
