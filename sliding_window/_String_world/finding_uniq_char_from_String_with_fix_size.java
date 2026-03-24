package sliding_window._String_world;



public class finding_uniq_char_from_String_with_fix_size {

    public static void main(String[] args) {
        String s = "aaabdaasdwwaads";
        int k = 2;

        System.out.println(find(s, k));
    }

    static int find(String s, int k) {

        int[] freq = new int[256]; // frequency array for characters
        int unique = 0;

        int low = 0;
        int res = -1;

        for (int high = 0; high < s.length(); high++) {

            char c = s.charAt(high);

            if (freq[c] == 0) {
                unique++;
            }

            freq[c]++;

            while (unique > k) {

                char left = s.charAt(low);

                freq[left]--;

                if (freq[left] == 0) {
                    unique--;
                }

                low++;
            }

            if (unique == k) {
                res = Math.max(res, high - low + 1);
            }
        }

        return res;
    }
}


