package BInarySearch;

import java.util.Scanner;

/*
    LeetCode 1482. Minimum Number of Days to Make m Bouquets

    Problem Statement:
    ------------------
    You are given an integer array bloomDay, an integer m, and an integer k.

    You want to make m bouquets. To make one bouquet, you need k adjacent flowers.

    The garden consists of n flowers. The i-th flower blooms on bloomDay[i].
    Each flower can be used in exactly one bouquet.

    Return the minimum number of days needed to make m bouquets.
    If it is impossible to make m bouquets, return -1.

    Example:
    --------
    Input:
    bloomDay = [1,10,3,10,2]
    m = 3
    k = 1

    Output:
    3

    Explanation:
    After day 3, flowers at positions 0, 2, and 4 have bloomed.
    Since each bouquet requires only 1 flower, we can make
    3 bouquets. Hence, the answer is 3.

    Approach:
    ---------
    1. If m * k > number of flowers, return -1.
    2. Apply Binary Search on the answer (days).
    3. For every middle day, check whether at least
       m bouquets can be formed.
    4. If possible, search on the left half.
       Otherwise, search on the right half.

    Time Complexity: O(n * log(maxBloomDay))
    Space Complexity: O(1)
*/

public class Bouquets {

    public static int minDays(int[] bloomDay, int m, int k) {

        // Impossible case
        if ((long) m * k > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find minimum and maximum bloom day
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Checks if m bouquets can be made by the given day
    public static boolean canMake(int[] bloomDay, int m, int k, int day) {

        int flowers = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {

                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;

                    if (bouquets >= m)
                        return true;
                }

            } else {
                flowers = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
            Input Format

            n
            bloomDay[0] bloomDay[1] ... bloomDay[n-1]
            m
            k

            Sample Input
            5
            1 10 3 10 2
            3
            1

            Sample Output
            3
        */

        int n = sc.nextInt();

        int[] bloomDay = new int[n];

        for (int i = 0; i < n; i++) {
            bloomDay[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(minDays(bloomDay, m, k));

        sc.close();
    }
}
