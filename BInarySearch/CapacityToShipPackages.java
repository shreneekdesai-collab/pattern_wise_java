package BInarySearch;

import java.util.Scanner;

/*
==============================================================
    LeetCode 1011. Capacity To Ship Packages Within D Days
==============================================================

Problem:
--------
A conveyor belt has packages with different weights.

weights[i] = weight of the i-th package.

The packages must be shipped in the given order.

Find the minimum ship capacity so that all packages
can be shipped within the given number of days.

--------------------------------------------------------------
Example

Input:
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5

Output:
15

Explanation:

Day 1 -> 1 2 3 4 5
Day 2 -> 6 7
Day 3 -> 8
Day 4 -> 9
Day 5 -> 10

Minimum Capacity = 15

--------------------------------------------------------------
Binary Search on Answer

Low  = Maximum package weight
High = Sum of all package weights

Question:
Can all packages be shipped within "mid" capacity?

YES -> Try smaller capacity
NO  -> Increase capacity

Time Complexity : O(n * log(sum))
Space Complexity: O(1)

==============================================================
*/

public class CapacityToShipPackages {

    // Returns minimum ship capacity
    public static int shipWithinDays(int[] weights, int days) {

        int low = 0;
        long high = 0;

        // Search Space
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        int ans = -1;

        // Binary Search
        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = (int) mid;
                high = mid - 1;
            } else {
                low = (int) (mid + 1);
            }
        }

        return ans;
    }

    // Check if all packages can be shipped within given days
    public static boolean canShip(int[] weights, int days, long capacity) {

        int daysUsed = 1;
        long load = 0;

        for (int weight : weights) {

            // Load package on same day
            if (load + weight <= capacity) {
                load += weight;
            }
            // Start next day
            else {
                daysUsed++;
                load = weight;

                if (daysUsed > days)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        Input Format

        n
        weights[0] weights[1] ... weights[n-1]
        days

        Sample Input

        10
        1 2 3 4 5 6 7 8 9 10
        5

        Sample Output

        15
        */

        int n = sc.nextInt();

        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        int days = sc.nextInt();

        System.out.println(shipWithinDays(weights, days));

        sc.close();
    }
}
