package kadanses_algo;



public class MaxSubarrayOneDeletion {

    public static void main(String[] args) {
        int[] arr = {1, -2, 0, 3};

        int result = maximumSum(arr);
        System.out.println("Maximum Sum with One Deletion: " + result);
    }

    public static int maximumSum(int[] arr) {
        int oneDelete = 0;
        int noDelete = arr[0];
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {

            oneDelete = Math.max(oneDelete + arr[i], noDelete);
            noDelete = Math.max(arr[i], noDelete + arr[i]);

            res = Math.max(res, Math.max(oneDelete, noDelete));
        }

        return res;
    }
}
