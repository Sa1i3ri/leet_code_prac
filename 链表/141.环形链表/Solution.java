import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }


    public static void main(String[] args){
        System.out.print(new Solution().hasCycle(ListNode.cirList(new int[]{3,2,0,4},1)));
    }
}