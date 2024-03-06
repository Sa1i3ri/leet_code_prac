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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0,head);

        ListNode fast = sentinel;
        for(int i =0;i<n-1;i++){
            fast = fast.next;
        }
        ListNode pre = sentinel;
        ListNode slow = sentinel;
        while (fast.next!=null){
            pre = slow;
            fast=fast.next;
            slow=slow.next;
        }
        pre.next = slow.next;
        return sentinel.next;
    }
}