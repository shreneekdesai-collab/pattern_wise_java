package Stack;

import java.util.*;

/*
    Problem: Next Greater Element II

    Given a circular integer array nums (i.e., next element of last index
    is the first element), return the next greater element for every element.

    The next greater element of x is the first element greater than x when
    traversing to the right (circularly). If it doesn't exist, return -1.

    -------------------------------------------------------

    Example 1:
    Input:  nums = [1, 2, 1]
    Output: [2, -1, 2]

    Example 2:
    Input:  nums = [1, 2, 3, 4, 3]
    Output: [2, 3, 4, -1, 4]

    -------------------------------------------------------

    Approach (Using Stack - Your Method):

    - First loop: push elements (except last) to simulate circular array
    - Second loop: process from right to left
    - Remove all smaller or equal elements
    - Top of stack gives next greater element
*/

public class nextGreaterelement_lc_503 {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        // Step 1: simulate circular array
        for (int i = n - 2; i >= 0; i--) {
            st.push(nums[i]);
        }

        // Step 2: process actual array
        for (int i = n - 1; i >= 0; i--) {

            // Remove smaller or equal elements
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            // Assign result
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            // Push current element
            st.push(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        // Hardcoded input
        int[] nums = { 1, 2, 1 };

        int[] result = nextGreaterElements(nums);

        System.out.println("Output:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
