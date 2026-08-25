package Heap;

import java.util.*;

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
// Input:
// nums = [1,1,1,2,2,3]
// k = 2

// Output:
// [1,2]

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step 2: Create max heap based on frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Step 3: Add unique numbers to heap
        for (int num : map.keySet()) {
            heap.add(num);
        }

        // Step 4: Get top k elements
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}
