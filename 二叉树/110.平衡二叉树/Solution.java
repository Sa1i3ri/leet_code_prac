/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getDeep(root)!=-1;
    }

    private int getDeep(TreeNode root){
        if(root==null) return 0;
        int left = getDeep(root.left);
        int right = getDeep(root.right);
        if(Math.min(left,right)==-1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

}