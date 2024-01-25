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
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root){
        if(root.left == null && root.right==null) return 1- root.val;

        int left_need = 0;
        int right_need = 0;

        if(root.left!=null){
            left_need = dfs(root.left);
        }
        if(root.right!=null){
            right_need = dfs(root.right);
        }

        if(left_need < 0){
            root.val += -left_need;
            res += -left_need;
        }
        if(right_need<0){
            root.val += -right_need;
            res += -right_need;
        }


        if(left_need > 0){
            res += left_need;
            root.val -= left_need;
        }
        if(right_need>0){
            res += right_need;
            root.val -= right_need;
        }

        return 1- root.val;


    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0,new TreeNode(0,new TreeNode(5),new TreeNode(0)),new TreeNode(0));
        System.out.println(new Solution().distributeCoins(root));
    }



}