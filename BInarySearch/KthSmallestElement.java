package BInarySearch;

/*
Problem:
Given an n x n matrix where each row and column is sorted
in ascending order, find the kth smallest element.

Example:
matrix = {
    {1, 5, 9},
    {10, 11, 13},
    {12, 13, 15}
}
k = 8

Output: 13
*/

public class KthSmallestElement {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {

            int mid = low + (high - low) / 2;

            int count = check(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Counts elements <= target
    static int check(int[][] matrix, int target) {

        int n = matrix.length;

        int row = n - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {

            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };

        int k = 8;

        KthSmallestElement obj = new KthSmallestElement();

        System.out.println(obj.kthSmallest(matrix, k));
    }
}
