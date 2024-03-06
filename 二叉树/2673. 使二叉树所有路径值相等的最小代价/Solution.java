class Solution {
    private int[] cost;
    private int len;
    private int res=0;
    public int minIncrements(int n, int[] cost) {
        this.cost = cost;
        this.len = n;
        dfs(0);
        return res;
    }

    private int dfs(int n){
        //返回的是子树所共同需要的路径和
        if(isLeaf(n))return cost[n];

        int left = dfs(leftChildOf(n));
        int right = dfs(rightChildOf(n));

        res += Math.abs(left-right);

        return Math.max(left,right)+cost[n];

    }

    private int leftChildOf(int n){
        return 2*n+1;
    }

    private int rightChildOf(int n){
        return 2*n+2;
    }

    private boolean isLeaf(int n){
        return leftChildOf(n)>=len;
    }

    public static void main(String[] args){
        System.out.println(new Solution().minIncrements(7,new int[]{1,5,2,2,3,3,1}));
    }


}