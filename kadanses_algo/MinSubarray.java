package kadanses_algo;

import java.util.*;

public class MinSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, 2, 4, 5};
        minsum(arr);
    }

    static void minsum(int[] arr) {
        int min = arr[0];
        int res = arr[0];

        int start = 0, end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {

            // Decide: start new OR continue
            if (arr[i] < min + arr[i]) {
                min = arr[i];
                tempStart = i;   // new subarray starts here
            } else {
                min = min + arr[i];
            }

            // Update result
            if (min < res) {
                res = min;
                start = tempStart;
                end = i;
            }
        }

        // Print result
        System.out.println("Minimum Sum: " + res);
        System.out.print("Subarray: ");

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}