package LinkedList;

public class Rotate_List {
    static class ListNode {
        int val;
        ListNode next;

     ListNode(int val){
        this.val=val;
     }

    }
    public static void main(String[] args) {
          ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original List : ");
        print(head);

        head = rotate(head, 3);

        System.out.print("After Reverse : ");
        print(head);


    }
    static ListNode rotate(ListNode head,int k){
        if(head == null || head.next== null || k == 0) return head;
         int len=1;
         ListNode tail=head;
         while (tail.next != null) {
                tail=tail.next;
                len++;
         }

         k=k%len;
         if (k == 0) {
            return head;
         }
         tail.next=head;


         int steps=len-k;

         ListNode newtail=head;
         for(int i=1;i<steps;i++){
            newtail=newtail.next;

         }
         ListNode newhead=newtail.next;

         newtail.next=null;

         return newhead;



    }
    static void print(ListNode head){
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
            }
            head=head.next;

        }
        System.out.println();
    }
}
