package org.example.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinarySearch {
    private BinarySearch() {
    }

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>(List.of(9, 1, 8, 0, 2, 3, 4, 5, 6));
        Collections.sort(values);

        System.out.println("Sorted list: " + values);
        System.out.println("Collections.binarySearch for 4 = " + Collections.binarySearch(values, 4));
        System.out.println("Left-most insertion index for 3 = " + lowerBound(values, 3));
        System.out.println("Contains 6 = " + contains(values, 6));
        System.out.println("Contains 10 = " + contains(values, 10));
    }

    public static boolean contains(List<Integer> values, int target) {
        int index = lowerBound(values, target);
        return index < values.size() && values.get(index) == target;
    }

    public static int lowerBound(List<Integer> values, int target) {
        int low = 0;
        int high = values.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (values.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
