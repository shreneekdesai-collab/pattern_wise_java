package BInarySearch;

import java.util.Scanner;

/*
=========================================================
    LeetCode 2226 - Maximum Candies Allocated to K Children
=========================================================

Problem:
--------
Given an array candies[], where candies[i] is the size of
the i-th candy pile, and an integer k (children).

You can split a pile into smaller piles but cannot combine
different piles.

Return the maximum candies each child can receive equally.
If impossible, return 0.

Example:
--------
Input:
candies = [5,8,6]
k = 3

Output:
5

Approach:
---------
Binary Search on Answer

Low  = 1
High = Maximum pile

Check:
Can every child receive 'mid' candies?

YES -> Search Right (larger answer)
NO  -> Search Left (smaller answer)

Time : O(n * log(maxPile))
Space: O(1)

=========================================================
*/

public class MaximumCandiesAllocated {

    // Returns maximum candies each child can receive
    public static int maximumCandies(int[] candies, long k) {

        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int candy : candies) {
            high = Math.max(high, candy);
        }

        // Total candies
        long total = 0;
        for (int candy : candies) {
            total += candy;
        }

        // Not enough candies
        if (total < k)
            return 0;

        int ans = 0;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canDistribute(candies, k, mid)) {
                ans = mid;
                low = mid + 1; // Try bigger answer
            } else {
                high = mid - 1; // Reduce answer
            }
        }

        return ans;
    }

    // Check if each child can receive 'mid' candies
    public static boolean canDistribute(int[] candies, long k, int mid) {

        long children = 0;

        for (int pile : candies) {

            children += pile / mid;

            if (children >= k)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        Input Format

        n
        candies[]
        k

        Sample Input
        3
        5 8 6
        3

        Sample Output
        5
        */

        int n = sc.nextInt();

        int[] candies = new int[n];

        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
        }

        long k = sc.nextLong();

        System.out.println(maximumCandies(candies, k));

        sc.close();
    }
}
