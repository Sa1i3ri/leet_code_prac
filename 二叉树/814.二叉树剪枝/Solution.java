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
    public TreeNode pruneTree(TreeNode root) {
        if(dfs(root)){
            return null;
        }
        return root;
    }

    private boolean dfs(TreeNode root){
        if(root.left==null && root.right==null && root.val==0) return true;
        if(root.left==null && root.right==null &&root.val==1) return false;


        boolean isLeft = true;
        boolean isRight = true;

        if(root.left!=null){
            isLeft = dfs(root.left);
        }
        if(root.right!=null){
            isRight = dfs(root.right);
        }

        if(isLeft){
            root.left = null;
        }

        if(isRight){
            root.right = null;
        }

        return root.val==0 && isLeft && isRight;

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1,null,new TreeNode(0,new TreeNode(0),new TreeNode(1)));
        System.out.println(new Solution().pruneTree(root));
    }

}