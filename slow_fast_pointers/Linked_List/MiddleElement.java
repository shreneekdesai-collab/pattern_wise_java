package slow_fast_pointers.Linked_List;

// Question:
// Given the head of a singly linked list, return the middle node.
// If there are two middle nodes, return the second middle node.
//
// Example:
// Input: 1 -> 2 -> 3 -> 4 -> 5
// Output: 3
//
// Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
// Output: 4

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MiddleElement {

    // Function to find middle node
    public static ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Slow moves 1 step, Fast moves 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Print Linked List
    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(head);

        ListNode middle = middleNode(head);

        System.out.println("Middle Node: " + middle.val);
    }
}
