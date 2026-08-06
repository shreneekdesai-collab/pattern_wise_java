package BInarySearch;

// Problem Statement

// You are given:

// An array stalls[] representing the positions of stalls.
// An integer k representing the number of cows.

// You have to place the cows in the stalls such that the minimum distance between any two cows is as large as possible.

// Return that largest minimum distance.
// Input:
// stalls = [1, 2, 4, 8, 9]
// k = 3

// Output:
// 3

public class Aggressive_Cows {
    public static void main(String[] args) {
         int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;

        System.out.println(aggressiveCows(stalls, cows));

    }
    static int aggressiveCows(int[]a,int cows){
        int low=1;
        int high=a[a.length-1]-a[0];

        int ans=0;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if(plasce(a,cows,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;

            }
        }
        return ans;
    }
   static boolean plasce(int[] a,int cows,int distance){
    int count=1;
    int last=a[0];
    for(int i=1;i<a.length-1;i++){
        if (a[i]-last >=distance) {
            count++;
            last=a[i];
              if (count == cows)
                    return true;
        }
    }
    return false;
   }
}
