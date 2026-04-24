package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].


public class Structure {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] result = merge(arr);

        // Output
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    public static int [][] merge(int [][] a ){
        if(a.length==0) return new int[0][0];
        Arrays.sort(a,(x,y)->x[0]-y[0]);

        List<int[]>res=new ArrayList<>();

        int start=a[0][0];
        int end=a[0][1];

        for (int i = 1; i < a.length; i++) {
            int start2=a[i][0];
            int end2=a[i][1];
            
            if(end>=start2){
                end=Math.max(end,end2);

            }else{
                res.add(new int[]{start,end});
                start=start2;
                end=end2;
            }
        }

        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);


    }
}
