package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Insert Interval using ARRAY approach (no List)

public class InsertIntervalArray {

    public static void main(String[] args) {

        int[][] arr = {
            {1, 3},
            {6, 9}
        };

        int[] inter = {2, 5};

        int[][] result = insert(arr, inter);

        for (int[] x : result) {
            System.out.println(x[0] + " " + x[1]);
        }
    }

    public static int[][] insert(int[][] a, int[] inter) {

       List<int []> res=new ArrayList<>();
       int [][] arr=new int[a.length+1][2];

       for (int i = 0; i < a.length; i++) {
         arr[i]=a[i];
       }
       arr[a.length]=inter;
       Arrays.sort(arr,(x,y)->x[0]-y[0]);


       int start=arr[0][0];
       int end=arr[0][1];
       
       for(int i=1;i<arr.length;i++){
        int s=arr[i][0];
        int e=arr[i][1];

        if (end>=s) {
            end=Math.max(end,e);
        }else{
            res.add(new int[]{start,end});
            start=s;
            end=e;

        }
       }
       res.add(new int[]{start,end});
       return res.toArray(new int[res.size()][]);
    }
}
