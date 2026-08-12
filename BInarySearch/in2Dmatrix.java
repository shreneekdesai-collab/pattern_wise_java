package BInarySearch;

public class in2Dmatrix {

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 16;

        int[] result = serch(matrix, target);

        if (result[0] != -1) {
            System.out.println("Target found");
            System.out.println("Row: " + result[0]);
            System.out.println("Column: " + result[1]);
        } else {
            System.out.println("Target not found");
        }
    }

    static int[] serch(int[][] Matrix, int target) {

        int rows = Matrix.length;
        int cols = Matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Convert 1D index into 2D index
            int row = mid / cols;
            int col = mid % cols;

            if (Matrix[row][col] == target) {
                return new int[]{row, col};
            }

            else if (Matrix[row][col] < target) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        // Target not found
        return new int[]{-1, -1};
    }
}
