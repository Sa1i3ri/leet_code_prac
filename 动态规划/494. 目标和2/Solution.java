import java.util.Arrays;

class Solution {
    private int[] nums;
    public int findTargetSumWays(int[] nums, int target) {
        /*
        p:正数和
        s:所有数的和
        n:负数和
        p - n = s
        p + n = t
        2p = s+t
        p = (s+t)/2
         */
        this.nums = nums;
        int sum = Arrays.stream(nums).sum();
        if((sum+target)%2==1 || sum+target<0) return 0;

        int[][] dp = new int[nums.length+1][target+1];
        dp[0][0] = 1;

        for(int i =1;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(j < nums[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i-1][(sum+target)/2-nums[i-1]];
                }
            }
        }

        return dp[nums.length][target];
    }

    private int dfs(int i,int num){
        if(i<0) return num==0?1:0;

        if(num<nums[i]) return dfs(i-1,num);

        return dfs(i-1,num) + dfs(i-1,num-nums[i]);

    }

    public static void main(String[] args){
        System.out.println(new Solution().findTargetSumWays(new int[]{1,1,1,1,1},3));
    }

}