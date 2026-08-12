package BInarySearch;

public class serchin_matrix {

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        int target = 5;

        boolean result = searchMatrix(matrix, target);

        System.out.println("Target found: " + result);
    }

    static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        // Check every row
        for (int i = 0; i < rows; i++) {

            int low = 0;
            int high = columns - 1;

            // Binary search in this row
            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (matrix[i][mid] == target) {
                    return true;
                }
                else if (matrix[i][mid] < target) {
                    // Target is on the right
                    low = mid + 1;
                }
                else {
                    // Target is on the left
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
