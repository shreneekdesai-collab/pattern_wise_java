package Stack;

import java.util.Scanner;
import java.util.Stack;

public class remove_nodes {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();

            ListNode node = new ListNode(val);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.print("Original List: ");
        print(head);

        head = find(head);

        System.out.print("After Removing Nodes: ");
        print(head);

        sc.close();
    }

    static ListNode find(ListNode head) {

        Stack<Integer> st = new Stack<>();

        while (head != null) {
            st.push(head.val);
            head = head.next;
        }

        ListNode dummy = null;
        int max = Integer.MIN_VALUE;

        while (!st.isEmpty()) {

            int val = st.pop();

            if (val >= max) {

                max = val;

                ListNode node = new ListNode(val);

                node.next = dummy;
                dummy = node;
            }
        }

        return dummy;
    }

    static void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }
}
