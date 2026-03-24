package Linked_List.slow_fast_pointers.s;

public class struecture {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        // Creating nodes
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Creating cycle
        fourth.next = second;

        struecture obj = new struecture();
        boolean result = obj.hasCycle(head);

        System.out.println(result);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
