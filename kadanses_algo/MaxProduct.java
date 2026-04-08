package kadanses_algo;



public class MaxProduct {
    public static void main(String[] args) {
        int[] arr = {-2, 1, 2, 4, 5};
        maxpro(arr);
    }

    static void maxpro(int[] a){
        int minpro = a[0];
        int maxpro = a[0];
        int res = a[0];

        for (int i = 1; i < a.length; i++) {

            int tempMax = maxpro;
            int tempMin = minpro;

            maxpro = Math.max(a[i], Math.max(a[i] * tempMax, a[i] * tempMin));
            minpro = Math.min(a[i], Math.min(a[i] * tempMax, a[i] * tempMin));

            res = Math.max(res, maxpro);
        }

        System.out.println("Max Product: " + res);
    }
}
