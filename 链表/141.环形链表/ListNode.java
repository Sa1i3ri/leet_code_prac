public class ListNode {
      int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode toList(int[] s){
        ListNode sentinel = new ListNode();
        ListNode temp = sentinel;
        for(int i =0;i<s.length;i++){
            temp.next = new ListNode(s[i]);
            temp = temp.next;
        }
        return sentinel.next;
    }

    public static ListNode cirList(int[] s,int pos){
        ListNode sentinel = new ListNode();
        ListNode temp = sentinel;
        ListNode cir = null;
        for(int i =0;i<s.length;i++){
            temp.next = new ListNode(s[i]);
            temp = temp.next;
            if(i==pos) cir=temp;
        }
        temp.next=cir;

        return sentinel.next;
    }

    public static void printList(ListNode head){
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}