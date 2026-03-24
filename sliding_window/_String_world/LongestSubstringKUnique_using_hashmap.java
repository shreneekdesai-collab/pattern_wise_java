package sliding_window._String_world;

import java.util.HashMap;

public class LongestSubstringKUnique_using_hashmap {

    public static void main(String[] args) {
        String s = "aaabdaasdwwaads";
        int k = 2;

        System.out.println(find(s, k));
    }

    static int find(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int low = 0;
        int res = -1;

        for (int high = 0; high < s.length(); high++) {

            char c = s.charAt(high);

            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {

                char left = s.charAt(low);

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }

                low++;
            }
            
            if (map.size() == k) {
                System.out.print(map);
                res = Math.max(res, high - low + 1);
            }
        }

        return res;
    }
}