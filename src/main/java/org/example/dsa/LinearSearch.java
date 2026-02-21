package org.example.dsa;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);


        System.out.println(list.stream().filter(e -> e.equals(5)).findFirst().get());
    }
}
