package sliding_window.number;

import java.util.Scanner;

public class finding_the_max_sum_of_subarray_new_approach {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num[] = new int[]{0, 0, 1, 2, 1, 2, 0};
        int k=in.nextInt();
        
        System.out.println(subArr(num,k));
    }
    static int subArr(int[] num, int k) {

    int sum = 0;
    int res;

    // 1️⃣ First window
    for (int i = 0; i < k; i++) {
        sum += num[i];
    }

    res = sum;

    int low = 0;

    // 2️⃣ Slide window
    for (int high = k; high < num.length; high++) {

        sum = sum + num[high] - num[low];
        low++;

        res = Math.max(res, sum);
    }

    return res;
}
}
