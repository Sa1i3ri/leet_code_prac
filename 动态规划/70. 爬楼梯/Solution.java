class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i = 2;i<dp.length;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[dp.length-1];

    }

    private int dfs(int n){
        if(n<0)return 0;
        if(n==0) return 1;

        return dfs(n-1) + dfs(n-2);

    }

    public static void main(String[] args){
        System.out.println(new Solution().climbStairs(2));
    }
}