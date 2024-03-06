import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        //以i下标为末尾的子序列长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i =0;i<nums.length;i++){
            int lastMaxDp = 0;
            for(int j =i;j>=0;j--){
                if(nums[j]<nums[i]){
                    lastMaxDp = Math.max(lastMaxDp,dp[j]);
                }
            }
            dp[i] = lastMaxDp+1;
        }

        return Arrays.stream(dp).max().getAsInt();

    }

    public static void main(String[] args){
        System.out.println(new Solution().lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

}