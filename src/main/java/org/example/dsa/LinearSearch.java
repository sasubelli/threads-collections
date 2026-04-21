package org.example.dsa;

import java.util.List;

public final class LinearSearch {
    private LinearSearch() {
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Index of 5 = " + linearSearch(values, 5));
        System.out.println("Index of 9 = " + linearSearch(values, 9));
    }

    public static int linearSearch(List<Integer> values, int key) {
        for (int index = 0; index < values.size(); index++) {
            if (values.get(index) == key) {
                return index;
            }
        }
        return -1;
    }
}
