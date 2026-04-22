package Prefix_sufix_Sum.HashMap;
// Problem: Subarray Sum Equals K

import java.util.HashMap;

// Approach:
// - Use prefix sum
// - Use HashMap to store sum frequencies

// Key Idea:
// If (currentSum - k) exists in map,
// then subarray with sum k exists.

// Time Complexity: O(n)
// Space Complexity: O(n)

public class Subarray_Sum_Equals_K {
    public static void main(String[] args) {
        int a[]={1,2,3};
        int k=3;

        System.out.println(solution(a,k));
    }

 static int solution(int []a,int k){
    HashMap<Integer,Integer> map=new HashMap<>();
    map.put(0, 1);
    
    int sum=0;

    int count=0;

    for (int i : a) {
        sum+=i;

        if(map.containsKey(sum-k)){
            count+=map.get(sum-k);
        }

        map.put(sum,map.getOrDefault(sum, 0)+1);
    }
    return count;
 }
}
