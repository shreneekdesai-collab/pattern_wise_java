package Prefix_sufix_Sum.HashMap;

import java.util.HashMap;

// Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
public class Subarray_Sums_Divisible_by_K {
    public static void main(String[] args) {
        int a[]={1,2,3,4};
        int k=5;
        System.out.println(subarraysDivByK(a,k));

    }
     public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        int sum=0;
        int count=0;

        for(int num: nums){
            sum+=num;
            int rem=sum % k;
            if(rem<0) rem+=k;
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}
