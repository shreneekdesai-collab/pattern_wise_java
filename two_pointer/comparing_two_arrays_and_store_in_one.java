package two_pointer;

import java.util.Arrays;

public class comparing_two_arrays_and_store_in_one {
    public static void main(String[] args) {
        int[] a=new int[]{2,13,24,5};
        int [] b=new int[]{5,7,8,6,4};

        
        System.out.print(Arrays.toString(fun(a, b)));
    }
    static int[] fun(int[]a,int[]b){
        int[] res=new int[8];

        int n=a.length-1;
        int m=b.length-1;
        int i=0;
        int j=0;
        int id=0;


        while (i<=n && j<=m) {
            if (a[i]<=b[j]) {
                res[id]=a[i];
                id++;
                i++;
            }else{
                res[id]=b[j];
                id++;
                j++;
            }
        }
        while (j<m) {
            res[id]=b[j];
            id++;
            j++;
        }
        while (i<n) {
            res[id]=a[i];
            id++;
            i++;
        }
        return res;

    }
}
