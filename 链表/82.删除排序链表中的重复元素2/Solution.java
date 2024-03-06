import javax.swing.plaf.basic.BasicSplitPaneUI;

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(-1000,head);
        ListNode cur = sentinel;
        while (cur.next!=null && cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int val = cur.next.val;
                while (cur.next!=null && cur.next.val==val){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }

        }
        return sentinel.next;
    }

    public static void main(String[] args){
        ListNode.printList(new Solution().deleteDuplicates(ListNode.toList(new int[]{1,2,3,3,4,4,5})));
    }

}