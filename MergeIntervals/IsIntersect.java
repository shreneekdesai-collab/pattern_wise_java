package MergeIntervals;
import java.util.*;

public class IsIntersect {

    static boolean isIntersect(int[][] a) {

        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        int end = a[0][1];

        for (int i = 1; i < a.length; i++) {
            if (a[i][0] <= end) {
                return true;
            }
            end = Math.max(end, a[i][1]);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        if (isIntersect(a))
            System.out.println("Intersecting");
        else
            System.out.println("Not Intersecting");

        sc.close();
    }
}