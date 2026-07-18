package LinkedList;


public class reverse_in_paires {
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

        head = swap(head);

        System.out.print("After Swapping: ");
        print(head);

    }
    static ListNode swap(ListNode head){
        ListNode dummy=new ListNode(0);
         dummy.next=head;

         ListNode prev=dummy;

         while (prev.next!=null && prev.next.next != null) {
            ListNode first=prev.next;
            ListNode second =first.next;

            first.next=second.next;
            second.next=first;
            prev.next=second;

            prev=first;

         }
         return dummy.next;
    }
    static void print(ListNode head){
        while (head !=null) {
            System.out.print(head.val);
            if(head.next != null){
            System.out.print("->");
        }
        head=head.next;
    }
    System.out.println();
    }



}
