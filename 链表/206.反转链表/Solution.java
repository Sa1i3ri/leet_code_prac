class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while (next!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next=pre;
        return cur;


    }
}