class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp!=null && temp.next!=null){
            while (temp.next!=null && temp.next.val == temp.val){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode.printList(new Solution().deleteDuplicates(ListNode.toList(new int[]{1,1,2,3,3})));
    }

}