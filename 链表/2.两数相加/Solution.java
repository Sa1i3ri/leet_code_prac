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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode last1 = l1;
        int len1 = 1;
        while (last1.next!=null){
            last1=last1.next;
            len1++;
        }

        ListNode last2 = l2;
        int len2 = 1;
        while (last2.next!=null){
            last2=last2.next;
            len2++;
        }

        while (len1<len2){
            last1.next = new ListNode(0);
            last1 = last1.next;
            len1++;
        }
        while (len2<len1){
            last2.next = new ListNode(0);
            last2 = last2.next;
            len2++;
        }

        ListNode sentinel = new ListNode();
        ListNode temp = sentinel;
        int c = 0;
        while (l1!=null && l2!=null){
            int num1 = l1.val;
            int num2 = l2.val;
            int sum = num1+num2+c;
            c = sum/10;

            ListNode cur = new ListNode(sum%10);
            temp.next = cur;
            temp = cur;

            l1=l1.next;
            l2=l2.next;
        }
        if(c!=0){
            ListNode cur = new ListNode(c);
            temp.next = cur;
            temp = cur;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode.printList(new Solution().addTwoNumbers(ListNode.toList(new int[]{9,9,9,9,9,9,9}),
                ListNode.toList(new int[]{9,9,9,9})));
    }



}



