package two_pointer;

import java.util.Arrays;
import java.util.Scanner;

public class two_sum {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }

        System.out.println("eneter thr target:");
        int k=in.nextInt();
        dothis(a,k);
        System.out.println(Arrays.toString(dothis(a, k)));
    }
    static int[] dothis(int[] a,int k){
        int n=a.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = n-1; j >0; j--) {
                while (i<j) {
                    int sum=a[i]+a[j];
                    if (sum ==k) {
                        return new int[]{i,j};
                    }else if(sum<k){
                        i++;
                    }else{
                        j--;
                    }
                }
            }
        }
        return new int[]{};
    }
}