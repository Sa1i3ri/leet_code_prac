class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean left = dfs(root.left,Long.MIN_VALUE,root.val);
        boolean right = dfs(root.right,root.val,Long.MAX_VALUE);
        return left&&right;
    }

    private boolean dfs(TreeNode root, long min, long max){
        if(root==null) return true;
        boolean isValid = root.val < max && root.val>min;
        if(!isValid)return false;

        boolean left = dfs(root.left,min,root.val);
        boolean right = dfs(root.right,root.val,max);

        return left&&right;

    }



}