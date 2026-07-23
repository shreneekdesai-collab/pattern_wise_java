package BInarySearch;

public class koko_eating_banana {
    public static void main(String[] args) {
        int a[]={3,6,7,11};
        int h=8;
        System.out.println(find(a, h));

    }
    static int find(int [] a,int h){
        int max=0;
        for(int keli:a){
            max=Math.max(max,keli);
        }
        int high=max;
        int low=1;
        int ans=max;
        while (high>=low) {
            int mid=low+(high-low)/2;
            int val=hours(a,mid);
            if(val<=h){
                ans=mid;
                high=mid-1;

            }else{
                low=mid+1;
            }

        }
        return ans;
    }
    static int hours(int []a,int speed){
        int h=0;
        for (int i : a) {
            h+=(i+speed-1)/speed;
        }

        return h;
    }
}
