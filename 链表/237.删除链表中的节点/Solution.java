import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next.next;
        node.val = node.next.val;
        node.next = next;
    }

    public static void main(String[] args){
        ListNode res = ListNode.toList(new int[]{4,5,1,9});
        new Solution().deleteNode(res.next);
        ListNode.printList(res);
    }

}