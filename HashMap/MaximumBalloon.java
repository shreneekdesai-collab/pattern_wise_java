package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class MaximumBalloon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String text = sc.nextLine();

        System.out.println("Maximum Balloons = " + maxNumberOfBalloons(text));

        sc.close();
    }

    static int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0);
        int o = map.getOrDefault('o', 0);
        int n = map.getOrDefault('n', 0);

        return Math.min(
                Math.min(b, a),
                Math.min(l / 2, Math.min(o / 2, n))
        );
    }
}
