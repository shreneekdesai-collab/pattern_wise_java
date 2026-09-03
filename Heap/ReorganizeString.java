package Heap;
// lc:767
// Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

import java.util.HashMap;
import java.util.PriorityQueue;

// Return any possible rearrangement of s or return "" if not possible.



// Example 1:

// Input: s = "aab"
// Output: "aba"

public class ReorganizeString {
    public static void main(String[] args) {
        String a="aab";
        System.out.println(organize(a));
    }

    static String organize(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a=s.charAt(i);
            map.put(a,map.getOrDefault(a, 0)+1);
        }
        PriorityQueue<Character> heap=new PriorityQueue<>((a,b)->{
                return map.get(b)-map.get(a);
        });

        for(char wrd:map.keySet()){
            heap.add(wrd);
        }

        StringBuilder ans=new StringBuilder();
        char previous='#';



        while (!heap.isEmpty()) {
            char current=heap.poll();
            if(current==previous){
                if(heap.isEmpty()) return "";
                char next=heap.poll();
                ans.append(next); 
                map.put(next, map.get(next)-1);
                if(map.get(next)>0) heap.add(next);
                heap.add(current);
                previous=next;

            }else{
                ans.append(current);
                map.put(current,map.get(current)-1);

                if(map.get(current)>0){
                    heap.add(current);
                }
                previous=current;
            }


        }
        return ans.toString();
    }

}
