package BInarySearch;

public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] a={5,6,7,1,2,3};
        int t=1;
        System.out.println(find(a,t));
    }
    static int find(int[] a,int k){
        int h=a.length-1;
        int l=0;

        while (h>=l) {
            int mid=l+(h-l)/2;

            if(a[mid]==k){
                return mid;
            }
            if(a[mid]>=a[l]){
                if(a[l] <= k && a[mid]>k ){
                    h=mid-1;

                }else{
                    l=mid+1;
                }
            }else{
                if (a[mid]< k && a[h]>=k) {
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }
}
