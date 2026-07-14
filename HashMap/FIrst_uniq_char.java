package HashMap;

import java.util.HashMap;
// 387
// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



// Example 1:

// Input: s = "leetcode"

// Output: 0

// Explanation:

// The character 'l' at index 0 is the first character that does not occur at any other index.


public class FIrst_uniq_char {
    public static void main(String[] args) {
        String s="leetcodelove";
        System.out.println(thatsit(s));
    }
    static int thatsit (String s){

        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(map.get(c)==1){
                return i;
            }
        }

        return -1;

    }
}
