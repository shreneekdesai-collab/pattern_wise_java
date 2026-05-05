package Stack;

import java.util.*;

/*
    Problem: Daily Temperatures

    Given an array of integers temp[] where temp[i] represents the temperature on the i-th day,
    return an array res[] such that:

    res[i] = number of days you have to wait after the i-th day to get a warmer temperature.

    If there is no future day for which this is possible, keep res[i] = 0.

    Example:
    Input:  temp = [73, 74, 75, 71, 69, 72, 76, 73]
    Output: res  = [1, 1, 4, 2, 1, 1, 0, 0]

    Explanation:
    - Day 0 (73) → wait 1 day → 74
    - Day 1 (74) → wait 1 day → 75
    - Day 2 (75) → wait 4 days → 76
    - Day 3 (71) → wait 2 days → 72
    - Day 4 (69) → wait 1 day → 72
    - Day 5 (72) → wait 1 day → 76
    - Day 6 (76) → no warmer day → 0
    - Day 7 (73) → no warmer day → 0
*/

public class dailytemp {

    public static int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove all smaller or equal temperatures
            while (!st.isEmpty() && temp[st.peek()] <= temp[i]) {
                st.pop();
            }

            // If no warmer day exists
            if (st.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = st.peek() - i;
            }

            // Push current index
            st.push(i);
        }

        return res;
    }

    public static void main(String[] args) {

        // Hardcoded input
        int[] temp = { 73, 74, 75, 71, 69, 72, 76, 73 };

        int[] result = dailyTemperatures(temp);

        System.out.println("Output:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
