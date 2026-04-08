package kadanses_algo;



public class MaxCircularSubarray {

    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println("Maximum Circular Subarray Sum: " + maxSubarraySumCircular(nums));
    }

    public static int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int maxSum = nums[0];
        int curMax = nums[0];

        int minSum = nums[0];
        int curMin = nums[0];

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            // Kadane for max
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);

            // Kadane for min
            curMin = Math.min(nums[i], curMin + nums[i]);
            minSum = Math.min(minSum, curMin);
        }

        // Edge case: all numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Return max of normal and circular
        return Math.max(maxSum, totalSum - minSum);
    }
}
