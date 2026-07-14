package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class Ransome_Note {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Ransom Note: ");
        String ransom = sc.nextLine();

        System.out.print("Enter Magazine: ");
        String magazine = sc.nextLine();

        boolean ans = find(ransom, magazine);

        System.out.println("Can Construct: " + ans);

        sc.close();
    }

    static boolean find(String a, String b) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Store frequency of magazine characters
        for (int i = 0; i < b.length(); i++) {
            char s = b.charAt(i);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // Check ransom note characters
        for (int i = 0; i < a.length(); i++) {
            char p = a.charAt(i);

            if (!map.containsKey(p) || map.get(p) == 0) {
                return false;
            }

            map.put(p, map.get(p) - 1);
        }

        return true;
    }
}
