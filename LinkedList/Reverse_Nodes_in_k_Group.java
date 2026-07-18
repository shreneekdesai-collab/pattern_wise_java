package LinkedList;

public class Reverse_Nodes_in_k_Group {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original List : ");
        print(head);

        head = reverseGroups(head, 3);

        System.out.print("After Reverse : ");
        print(head);
    }

    static ListNode reverseGroups(ListNode head, int k) {

        if (head == null || k == 1)
            return head;

        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;
        ListNode next = null;

        while (length >= k) {

            for (int i = 1; i < k; i++) {

                next = current.next;

                current.next = next.next;

                next.next = prev.next;

                prev.next = next;
            }

            prev = current;
            current = current.next;

            length -= k;
        }

        return dummy.next;
    }

    static void print(ListNode head) {

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null)
                System.out.print(" -> ");

            head = head.next;
        }

        System.out.println();
    }
}
