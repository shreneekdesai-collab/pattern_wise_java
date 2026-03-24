package two_pointer;

import java.util.Arrays;

public class Dutch_national_flag {

    public static void main(String[] args) {
        int num[] = new int[]{0, 0, 1, 2, 1, 2, 0};
        sortColors(num);
        System.out.println(Arrays.toString(num));
    }

    public static void sortColors(int[] num) {

        int low = 0;
        int mid = 0;
        int high = num.length - 1;

        while(mid <= high) {

            if(num[mid] == 0) {
                swap(num, low, mid);
                low++;
                mid++;
            }
            else if(num[mid] == 1) {
                mid++;
            }
            else {
                swap(num, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}