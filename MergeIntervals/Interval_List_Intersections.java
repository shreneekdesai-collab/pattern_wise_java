package MergeIntervals;

import java.lang.reflect.Array;

import java.util.*;
// 986. Interval List Intersections

// You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

// Return the intersection of these two interval lists.

// A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

// The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
public class Interval_List_Intersections {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {

            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                res.add(new int[]{start, end});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

        int[][] firstList = {
            {0, 2},
            {5, 10},
            {13, 23},
            {24, 25}
        };

        int[][] secondList = {
            {1, 5},
            {8, 12},
            {15, 24},
            {25, 26}
        };

        int[][] ans = intervalIntersection(firstList, secondList);

        System.out.println(Arrays.deepToString(ans));
    }
}
