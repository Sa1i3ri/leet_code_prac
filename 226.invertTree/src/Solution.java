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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root){
        if(root.left==null && root.right==null) return;//叶
        if(root.left!=null) reverse(root.left);
        if(root.right!=null) reverse(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    public static void main(String[] argv){
        TreeNode left1 = new TreeNode(1);
        TreeNode right3 = new TreeNode(3);
        TreeNode left6 = new TreeNode(6);
        TreeNode left9 = new TreeNode(9);
        TreeNode left2 = new TreeNode(2,left1,right3);
        TreeNode right7 = new TreeNode(7,left6,left9);

        TreeNode root = new TreeNode(4,left2,right7);
        Solution solution = new Solution();
        root = solution.invertTree(root);
        TreeNode show = root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
  }