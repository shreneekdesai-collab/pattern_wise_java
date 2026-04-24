package Prefix_sufix_Sum.Deque;

import java.util.*;

public class Shortest_Subarray_With_Sum_At_Least_K {

    public static int shortestSubarray(int[] nums, int k) {

        int n = nums.length;
        long[] prefix = new long[n + 1];

        // build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            // condition: valid subarray
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - dq.pollFirst());
            }

            // maintain increasing prefix
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 2};
        int k = 3;

        System.out.println(shortestSubarray(nums, k)); // Output: 3
    }
}
