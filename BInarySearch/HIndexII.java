package BInarySearch;

import java.util.Scanner;

/*
=========================================================
            LeetCode 275 - H-Index II
=========================================================

Problem:
--------
Given a sorted array citations[], where citations[i] is
the number of citations of the i-th paper.

Return the researcher's H-Index.

H-Index:
A researcher has H-Index = h if at least h papers have
at least h citations each.

The array is already sorted, so solve it in O(log n).

---------------------------------------------------------
Example

Input:
citations = [0,1,3,5,6]

Output:
3

Explanation:
There are 3 papers having at least 3 citations.

---------------------------------------------------------
Approach

Binary Search

Condition:
citations[mid] >= n - mid

YES -> Search Left (First True)
NO  -> Search Right

Answer = n - low

Time : O(log n)
Space: O(1)

=========================================================
*/

public class HIndexII {

    // Returns H-Index
    public static int hIndex(int[] citations) {

        int n = citations.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Enough citations
            if (citations[mid] >= n - mid) {

                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return n - low;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        Input Format

        n
        citations[]

        Sample Input

        5
        0 1 3 5 6

        Sample Output

        3
        */

        int n = sc.nextInt();

        int[] citations = new int[n];

        for (int i = 0; i < n; i++) {
            citations[i] = sc.nextInt();
        }

        System.out.println(hIndex(citations));

        sc.close();
    }
}
