package sliding_window._String_world;

import java.util.HashMap;
import java.util.HashSet;

public class subarray_without_suplicates {
    public static void main(String[] args) {
        String s="abcdascg";
        System.out.println(find(s));
    }
    static int find(String s){
        HashSet<Character> set=new HashSet<>();

        int res=0,low=0;
        for (int high = 0; high < s.length(); high++) {
            char  c=s.charAt(high);
            while (set.contains(c)) {
                set.remove(s.charAt(low));
                low++;
            }
            set.add(c);
            res=Math.max(res, high-low+1);
        }

    return res;

    }
}
