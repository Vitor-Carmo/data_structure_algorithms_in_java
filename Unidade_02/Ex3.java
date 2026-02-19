package Unidade_02;

import java.util.ArrayList;

public class Ex3 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(5);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(2);
        list2.add(4);
        list2.add(6);

        ArrayList<Integer> mergedList = mergeLists(list1, list2);
        System.out.println("Lista mesclada: " + mergedList);
    }

    public static ArrayList<Integer> mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int maxLength = Math.max(list1.size(), list2.size());
        for (int i = 0; i < maxLength; i++) {
            if (i < list1.size()) {
                mergedList.add(list1.get(i));
            }
            if (i < list2.size()) {
                mergedList.add(list2.get(i));
            }
        }
        return mergedList;

    }
}