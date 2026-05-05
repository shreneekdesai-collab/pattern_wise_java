package Stack;

import java.util.*;

/*
    Problem: Remove All Adjacent Duplicates in String II

    You are given a string s and an integer k.

    A k-duplicate removal consists of removing k adjacent equal characters.
    After removal, the remaining parts of the string join together.

    Repeat this process until no more removals can be done.

    Return the final string.

    -------------------------------------------------------

    Example 1:
    Input:  s = "abcd", k = 2
    Output: "abcd"

    Example 2:
    Input:  s = "deeedbbcccbdaa", k = 3
    Output: "aa"

    Example 3:
    Input:  s = "pbbcggttciiippooaais", k = 2
    Output: "ps"

    -------------------------------------------------------

    Approach:

    Use a Stack of (character, count)

    - If same character → increase count
    - If count == k → remove it
    - Otherwise keep pushing

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

public class removeduplicate {

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!st.isEmpty() && st.peek().ch == c) {
                st.peek().count++;

                if (st.peek().count == k) {
                    st.pop(); // remove k duplicates
                }
            } else {
                st.push(new Pair(c, 1));
            }
        }

        // Build result string
        StringBuilder res = new StringBuilder();

        for (Pair p : st) {
            for (int i = 0; i < p.count; i++) {
                res.append(p.ch);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {

        // Hardcoded input
        String s = "deeedbbcccbdaa";
        int k = 3;

        String result = removeDuplicates(s, k);

        System.out.println("Output: " + result);
    }
}
