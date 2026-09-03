package Heap;
import java.util.*;

public class MergeKSortedArray {

    // Node stores:
    // value = element from matrix
    // row   = which row it belongs to
    // col   = which column it belongs to
    static class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    static ArrayList<Integer> mergeRows(int[][] mat) {

        // Min Heap based on value
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.value - b.value);

        ArrayList<Integer> ans = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        // Add first element of every row
        for (int i = 0; i < n; i++) {
            pq.offer(new Node(mat[i][0], i, 0));
        }

        // Process all elements
        while (!pq.isEmpty()) {

            Node current = pq.poll();

            // Add smallest element to answer
            ans.add(current.value);

            // Get next element from the same row
            int nextCol = current.col + 1;

            if (nextCol < m) {
                pq.offer(
                        new Node(
                                mat[current.row][nextCol],
                                current.row,
                                nextCol
                        )
                );
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };

        ArrayList<Integer> result = mergeRows(mat);

        System.out.println("Sorted Array: " + result);
    }
}
