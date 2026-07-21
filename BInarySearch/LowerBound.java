package BInarySearch;



import java.util.Arrays;

public class LowerBound {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 2, 3, 3, 4, 5};

        int target = 2;

        int index = lowerBound(arr, target);

        System.out.println("Lower Bound Index = " + index);
    }

    static int lowerBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
