package two_pointer;

import java.util.Scanner;

public class no_Of_Uniq_element {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size:");
        int n=in.nextInt();
        System.out.println("Entert the elemenet:");
        int a[]=new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i]=in.nextInt();
        }
        uniq(a);
        System.out.println(uniq(a));
    }
    static int uniq(int[] a) {
    if (a.length == 0) return 0;

    int count = 1;  

    for (int i = 1; i < a.length; i++) {
        if (a[i] != a[i - 1]) {
            count++;
        }
    }

    return count;
}

    }

