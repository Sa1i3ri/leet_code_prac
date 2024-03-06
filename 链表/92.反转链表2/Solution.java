/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(0,head);
        ListNode temp = sentinel;
        for(int i =0;i<left-1;i++){
            temp = temp.next;
        }
        ListNode pre = null;
        ListNode cur = temp.next;
        ListNode next;

        for(int i =0;i<right-left+1;i++){
            next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }

        temp.next.next=cur;
        temp.next = pre;


        return sentinel.next;
    }




}