import java.io.FilterOutputStream;

class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = find_mid(head);
        ListNode list2 = reverse(mid);
        ListNode now = head;
        while ( list2.next!=null){
            ListNode next = now.next;
            now.next = list2;
            now = list2;
            list2 = list2.next;
            now.next = next;
            now = now.next;
        }
    }


    private ListNode find_mid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode first) {
        ListNode head = null;
        ListNode mid = first;
        ListNode tail = first.next;

        while (true){
            mid.next = head;
            if(tail == null)break;
            head = mid;
            mid = tail;
            tail = tail.next;
        }
        return mid;

    }



}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
