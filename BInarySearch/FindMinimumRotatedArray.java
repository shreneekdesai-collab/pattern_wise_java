package BInarySearch;

public class FindMinimumRotatedArray {

    public static void main(String[] args) {

        int[] nums = {5, 6, 7, 1, 2, 3, 4};

        int ans = findMin(nums);

        System.out.println("Minimum element is: " + ans);
    }

    static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            System.out.println("-------------------------");
            System.out.println("low = " + low + " (" + nums[low] + ")");
            System.out.println("mid = " + mid + " (" + nums[mid] + ")");
            System.out.println("high = " + high + " (" + nums[high] + ")");

            if (nums[mid] > nums[high]) {
                System.out.println(nums[mid] + " > " + nums[high]);
                System.out.println("Minimum is in the RIGHT half.");
                low = mid + 1;
            } else {
                System.out.println(nums[mid] + " <= " + nums[high]);
                System.out.println("Minimum is in the LEFT half (including mid).");
                high = mid;
            }
        }

        return nums[low];
    }
}
