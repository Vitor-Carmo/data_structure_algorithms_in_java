package Unidade_02;

import java.util.ArrayList;

public class Ex1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("Lista original: " + list);

        reverse(list);

        System.out.println("Lista reversa: " + list);

    }

    public static void reverse(ArrayList<Integer> arr) {
        int size = arr.size();

        for (int i = 0; i < size / 2; i++) {
            int temp = arr.get(i);
            arr.set(i, arr.get(size - i - 1));
            arr.set(size - i - 1, temp);

        }
    }
}