package Prefix_sufix_Sum.HashMap;

import java.util.HashMap;
// Contiguous Array (Max Length of Equal 0s and 1s)

// Given a binary array nums,
// return the maximum length of a contiguous subarray with equal number of 0s and 1s.

public class Contiguous_Array {

    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int z = 0; // count of zeros
        int o = 0; // count of ones
        int maxLen = 0;

        map.put(0, -1); // base case

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                z++;
            } else {
                o++;
            }

            int diff = z - o;

            if (map.containsKey(diff)) {
                int len = i - map.get(diff);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(diff, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 1, 1, 0};

        int result = findMaxLength(nums);

        System.out.println("Max Length: " + result); // Expected: 6
    }
}
