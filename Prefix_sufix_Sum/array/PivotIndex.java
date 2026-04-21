package Prefix_sufix_Sum.array;

import java.util.*;

public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};

        int result = pivotIndex(nums);

        System.out.println("Pivot Index: " + result);
    }

    public static int pivotIndex(int[] nums) {

        int total = 0;

        // Step 1: calculate total sum
        for (int num : nums) {
            total += num;
        }

        int left = 0;

        // Step 2: check each index
        for (int i = 0; i < nums.length; i++) {

            int right = total - left - nums[i];

            if (left == right) {
                return i;
            }

            left += nums[i];
        }

        return -1;
    }
}
