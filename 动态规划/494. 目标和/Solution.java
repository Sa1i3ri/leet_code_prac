import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //p
        //s-p
        //p-(s-p)==t
        //p == (s+t)/2
        target += Arrays.stream(nums).sum();
        if(target<0 || (target&1)==1) return 0;
        target/=2;

        int[][] dp = new int[nums.length+1][target+1];
        dp[0][0] = 1;
        for(int i=1;i<dp.length;i++){
            //i是当前选的数字
            int num = nums[i-1];
            for(int j=0;j<dp[0].length;j++){
                //j是当前的target
                dp[i][j] = dp[i-1][j];//没选这个数字
                if(num <= j){
                    dp[i][j] += dp[i-1][j-num];//选了这个数字
                }
            }
        }


        return dp[dp.length-1][dp[0].length-1];
    }

    private int dfs(int[] nums, int start,int target){
        if(start==nums.length) return target==0?1:0;
        return dfs(nums,start+1,target-nums[start]) + dfs(nums,start+1,target);
    }

    public static void main(String[] args){
        System.out.println(new Solution().findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}