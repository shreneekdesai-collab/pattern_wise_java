package LinkedList;

/*
==========================================================
LeetCode 92 - Reverse Linked List II
Difficulty: Medium
==========================================================

Problem:
Reverse the nodes of a linked list from position
'left' to 'right' and return the modified list.

Example:
Input:
1 -> 2 -> 3 -> 4 -> 5
left = 2, right = 4

Output:
1 -> 4 -> 3 -> 2 -> 5

Approach:
1. Create a dummy node.
2. Move 'prev' to the node before 'left'.
3. Reverse (right - left + 1) nodes.
4. Connect:
   prev.next = reversed head
   leftNode.next = remaining list

Time Complexity : O(n)
Space Complexity: O(1)
==========================================================
*/

public class ReverseLinkedList_II {

    // Linked List Node
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    //---------------------------------------------------------
    // Reverse Between
    //---------------------------------------------------------

    static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right)
            return head;

        // Dummy Node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to node before left
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Start reversing
        ListNode current = prev.next;
        ListNode previous = null;

        for (int i = 0; i <= right - left; i++) {

            ListNode next = current.next;

            current.next = previous;

            previous = current;

            current = next;
        }

        // Reconnect

        ListNode leftNode = prev.next;

        prev.next = previous;

        leftNode.next = current;

        return dummy.next;
    }

    //---------------------------------------------------------
    // Print Linked List
    //---------------------------------------------------------

    static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null)
                System.out.print(" -> ");

            head = head.next;
        }

        System.out.println();
    }

    //---------------------------------------------------------
    // Main
    //---------------------------------------------------------

    public static void main(String[] args) {

        /*
         Linked List

         1 -> 2 -> 3 -> 4 -> 5
        */

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);

        head.next.next = new ListNode(3);

        head.next.next.next = new ListNode(4);

        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        int left = 2;
        int right = 4;

        head = reverseBetween(head, left, right);

        System.out.println();

        System.out.println("Reversed Between " + left + " and " + right + ":");

        printList(head);
    }
}
