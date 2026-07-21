package BInarySearch;

public class upperBound {
    public static void main(String[] args) {
        int [] a={2,3,1,3,5,2,2,4};
        int n=7;
        System.out.println(upper(a,n));
    }
    static int upper(int[] a,int k){
        int low=0;
        int high=a.length-1;
        int ans=a.length;


        while (high>low) {
            int mid=low+(high-low)/2;
            if(k==a[mid]){
                return mid;
            }else if(a[mid]>k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
