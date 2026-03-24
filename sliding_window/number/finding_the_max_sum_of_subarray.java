package sliding_window.number;

import java.util.Arrays;
import java.util.Scanner;

public class finding_the_max_sum_of_subarray {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num[] = new int[]{0, 0, 1, 2, 1, 2, 0};
        int k=in.nextInt();
        
        System.out.println(subArr(num,k));
    }
    public static int subArr(int[] num,int k){
        int maxsum=Integer.MIN_VALUE;
        int windowsum=0;

        for (int i = 0; i <k; i++) {
            windowsum+=num[i];
        }
        maxsum=windowsum;   

        for (int i = k; i < num.length; i++) {
                windowsum+=num[i]-num[i-k];
                maxsum=Math.max(maxsum, windowsum);            
        }

        return maxsum;


    }
}
