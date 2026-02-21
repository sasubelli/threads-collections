package org.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, 3));
        System.out.println(Collections.binarySearch(list, 4));

        System.out.println(Arrays.binarySearch(list.toArray(), 5));

        System.out.println(BinarySearch.binarySearchalgo(list, 6));

        System.out.println(BinarySearch.binarySearchalgo(list, 1));
        System.out.println(BinarySearch.binarySearchalgo(list, 2));
        System.out.println(BinarySearch.binarySearchalgo(list, 3));
    }

    static Integer binarySearchalgo(List<Integer> list, int n) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= n) {
                high = mid - 1;
            }
            if (list.get(mid) < n) {
                low = mid + 1;
            }
        }
        return low;
    }
}
