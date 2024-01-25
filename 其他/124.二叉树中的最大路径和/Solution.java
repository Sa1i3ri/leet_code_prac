
class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        this.max = Integer.MIN_VALUE;
        dfs(root);
        return max==Integer.MIN_VALUE?0:max;
    }

    private int dfs(TreeNode root){
        if(root==null) return 0;

        int left =Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        int cur = root.val;

        this.max = Math.max(max,left+right+cur);

        return cur + Math.max(0,Math.max(left,right));
    }


    public static void main(String[] args){
        System.out.println(new Solution().maxPathSum(new TreeNode(-3)));
    }
}


