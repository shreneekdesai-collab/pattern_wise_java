package Prefix_sufix_Sum.array;

import java.util.Arrays;
import java.util.Vector;

public class prefixsum {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        System.out.println(Arrays.toString(prefix(a)));
        
    }

   static int[] prefix(int[] a){
    int [] vec=new int[a.length];
    vec[0]=a[0];
   
    for (int i = 1; i < a.length; i++) {
        vec[i]=vec[i-1]+a[i];
    }
    return vec;
   }
}
