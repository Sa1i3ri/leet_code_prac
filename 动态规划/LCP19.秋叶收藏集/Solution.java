class Solution {
    public int minimumOperations(String leaves) {
        int[][] dp = new int[leaves.length()][3];
        dp[0][0] = leaves.charAt(0)=='r'?0:1;
        dp[0][1] = 100;
        dp[0][2] = 100;
        dp[1][2] = 100;

        for(int i =1;i<leaves.length();i++){
            char cur = leaves.charAt(i);
            if(cur=='r'){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][0]+1,dp[i-1][1]+1);
                dp[i][2] = Math.min(dp[i-1][1],dp[i-1][2]);
            } else if (cur == 'y') {
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]);
                dp[i][2] = Math.min(dp[i-1][1]+1,dp[i-1][2]+1);
            }
        }
        return dp[leaves.length()-1][2];

    }

    public static void main(String[] args){
        System.out.println(new Solution().minimumOperations("ryyyr"));
    }
}