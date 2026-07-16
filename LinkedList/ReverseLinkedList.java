package LinkedList;

public class ReverseLinkedList {

    // Node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Reverse Linked List
    static ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {

            ListNode next = current.next; // Save next node

            current.next = prev;          // Reverse link

            prev = current;               // Move prev

            current = next;               // Move current
        }

        return prev;
    }

    // Print Linked List
    static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Creating Linked List
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}
