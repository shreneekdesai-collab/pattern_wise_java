package Heap;

/*
 * LeetCode 658 - Find K Closest Elements
 *
 * Problem:
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x.
 *
 * If two numbers have the same distance from x,
 * choose the smaller number.
 *
 * Example:
 * Input:  arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 */

import java.util.*;

public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        // Heap stores the actual numbers.
        // Comparator decides which number is closer to x.
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {

            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);

            // Smaller distance gets higher priority
            if (diffA != diffB) {
                return diffA - diffB;
            }

            // Same distance -> smaller number first
            return a - b;
        });

        // Add all elements to the heap
        for (int num : arr) {
            heap.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        // Take k closest elements
        for (int i = 0; i < k; i++) {
            ans.add(heap.poll());
        }

        // Result must be sorted
        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        System.out.println(findClosestElements(arr, k, x));
    }
}
