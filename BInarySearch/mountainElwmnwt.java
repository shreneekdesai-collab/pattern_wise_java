package BInarySearch;
// lc-852

public class mountainElwmnwt {
    public static void main(String[] args) {
        int[] a = {2,5,6,9,8,4,1};
        findpeek(a);
    }
    static void findpeek(int[] a){
        int low=0;
        int high=a.length-1;
        while (high> low) {
            int mid=low+(high-low)/2;
            if(a[mid]<a[mid+1]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        System.out.println(low);
    }
}
