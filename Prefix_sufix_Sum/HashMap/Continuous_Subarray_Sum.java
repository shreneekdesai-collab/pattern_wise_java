package Prefix_sufix_Sum.HashMap;

import java.util.HashMap;

// Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

// A good subarray is a subarray where:

//     its length is at least two, and
//     the sum of the elements of the subarray is a multiple of k.

public class Continuous_Subarray_Sum {

     public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;

        System.out.println(checkSubarraySum(nums, k)); // true
    }
     public static boolean checkSubarraySum(int[] nums, int k) {
         HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int rem = sum % k;

            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i); // store first occurrence only
            }
        }

        return false;
     }
}
