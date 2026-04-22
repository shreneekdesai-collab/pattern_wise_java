package sliding_window.number;

public class Subarray_Product_Less_Than_K {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        
        // Edge case
        if (k <= 1) return 0;

        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // shrink window until valid
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // count subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {10, 5, 2, 6};
        int k = 100;

        int result = numSubarrayProductLessThanK(nums, k);

        System.out.println("Number of subarrays: " + result); // Expected: 8
    }
}
