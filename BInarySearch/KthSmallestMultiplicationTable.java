package BInarySearch;


/*
Problem:
Given an m x n multiplication table, find the kth smallest element.

Example:
m = 3, n = 3, k = 5

Table:
1  2  3
2  4  6
3  6  9

Output: 3
*/

public class KthSmallestMultiplicationTable {

    public static int findKthNumber(int m, int n, int k) {

        int low = 1;
        int high = m * n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            int count = check(m, n, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Count elements <= target
    static int check(int m, int n, int target) {

        int count = 0;

        for (int i = 1; i <= m; i++) {
            count += Math.min(target / i, n);
        }

        return count;
    }

    public static void main(String[] args) {

        int m = 3;
        int n = 3;
        int k = 5;

        int result = findKthNumber(m, n, k);

        System.out.println("Kth smallest element: " + result);
    }
}
