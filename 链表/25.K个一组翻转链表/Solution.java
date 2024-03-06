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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode sentinel = new ListNode(0,head);
        int len = len(head);
        int times = len/k;
        if(times==0) return head;
        ListNode temp =sentinel;
        for(int i =0;i<times;i++){
            //int start = i * k+1;

            ListNode pre = temp;
            ListNode cur = temp.next;
            ListNode next;
            for(int j = 0;j<k;j++){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            temp.next.next = cur;
            temp.next = pre;

            for(int j =0;j<k;j++){
                temp=temp.next;
            }
        }
        return sentinel.next;
    }

    private int len(ListNode head){
        int count = 0;
        ListNode temp = head;
        while (temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }



    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode res = solution.reverseKGroup(ListNode.toList(new int[]{1,2,3,4,5,6}),2);
        ListNode.printList(res);
    }


}