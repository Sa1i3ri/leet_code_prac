class Solution {
    public int stoneGameVII(int[] stones) {
        int[][] dp = new int[stones.length][stones.length];
        int[] sum = new int[stones.length+1];
        for(int i =0;i<stones.length;i++){
            sum[i+1] = sum[i]+stones[i];
        }

        for(int i = 1;i<stones.length;i++){
            //i是距离
            for(int j =0;j<stones.length-i;j++){
                //j是起点
                dp[j][j+i] = Math.max(sum[j+i]-sum[j] - dp[j][j+i-1],sum[j+i+1]-sum[j+1] - dp[j+1][j+i]);
                //dp[j][j+i] = Math.max(getSum(sum,j,j+i-1) - dp[j][j+i-1],getSum(sum,j+1,j+i) - dp[j+1][j+i]);
            }
        }
        return dp[0][stones.length-1];
    }

    private int getSum(int sum[],int start,int last){
        return sum[last+1] - sum[start];
    }


    public static void main(String[] args){
        System.out.println(new Solution().stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
    }
}