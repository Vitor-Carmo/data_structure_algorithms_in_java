package Unidade_02;

import java.util.ArrayList;
import java.util.Stack;

public class Ex5 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("Lista original: " + list);
        System.out.println("Lista reversa: " + reverse(list));
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> list) {
        Stack<Integer> stack = new Stack<>();

        for (int n : list) {
            stack.push(n);
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, stack.pop());
        }

        return list;
    }
}