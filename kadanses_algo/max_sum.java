package kadanses_algo;

public class max_sum {
    public static void main(String[] args) {
        int [] arr={-2,1,2,4,5};
        maxsum(arr);
    }
    static void maxsum(int [] arr){
        int sum=arr[0];

        int res=arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum=Math.max(arr[i],arr[i]+sum);
            res=Math.max(res, sum);    

        }
        System.out.println(res);
        
    }
}
