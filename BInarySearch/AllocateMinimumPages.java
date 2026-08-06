package BInarySearch;

import java.util.Scanner;

/*
=========================================================
        Allocate Minimum Number of Pages (GFG)
=========================================================

Problem:
--------
Given an array arr[] where arr[i] is the number of pages
in the i-th book and k students.

Allocate books such that:
1. Every student gets at least one book.
2. Books given to a student must be contiguous.
3. Every book is allocated.
4. One book cannot be shared.

Return the minimum possible value of the maximum pages
assigned to any student.

Return -1 if students > books.

---------------------------------------------------------
Example

Input:
arr = [12, 34, 67, 90]
k = 2

Output:
113

Explanation:
Student 1 -> [12, 34, 67] = 113
Student 2 -> [90] = 90

Maximum pages = 113 (Minimum Possible)

---------------------------------------------------------
Binary Search on Answer

Search Space

Low  = Maximum book pages
High = Sum of all pages

Question:
Can we allocate books so that no student gets
more than "mid" pages?

YES -> Try smaller answer
NO  -> Need larger answer

Time  : O(n * log(sum))
Space : O(1)
=========================================================
*/

public class AllocateMinimumPages {

    // Returns minimum possible maximum pages
    public static int findPages(int[] arr, int k) {

        // Impossible
        if (k > arr.length)
            return -1;

        int low = 0;
        long high = 0;

        // Search Space
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int ans = -1;

        // Binary Search
        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                ans = (int) mid;
                high = mid - 1;
            } else {
                low = (int) (mid + 1);
            }
        }

        return ans;
    }

    // Check if allocation is possible with maxPages = mid
    public static boolean canAllocate(int[] arr, int k, long mid) {

        int students = 1;
        long pages = 0;

        for (int book : arr) {

            // Give current book to same student
            if (pages + book <= mid) {
                pages += book;
            }
            // Give book to next student
            else {

                students++;
                pages = book;

                // More students needed
                if (students > k)
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
        arr[0] arr[1] ... arr[n-1]
        k

        Sample Input

        4
        12 34 67 90
        2

        Sample Output

        113
        */

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(findPages(arr, k));

        sc.close();
    }
}
