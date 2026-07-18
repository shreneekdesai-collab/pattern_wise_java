package sliding_window.number;

/*
------------------------------------------------------------
Problem: Max Consecutive Ones III

Given a binary array nums and an integer k.

You can flip at most k zeros into ones.

Return the maximum number of consecutive 1s that can be obtained.

Example:
Input:
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2

Output:
6

Time Complexity: O(n)
Space Complexity: O(1)
------------------------------------------------------------
*/

public class LongestOnes {

    public static int longestOnes(int[] nums, int k) {

        int low = 0;
        int count = 0;
        int max = 0;

        for (int high = 0; high < nums.length; high++) {

            if (nums[high] == 0)
                count++;

            while (count > k) {
                if (nums[low] == 0)
                    count--;
                low++;
            }

            max = Math.max(max, high - low + 1);
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println("Maximum Consecutive Ones = " + longestOnes(nums, k));
    }
}
