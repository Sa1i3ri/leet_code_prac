class Solution {
    public boolean validPartition(int[] nums) {
        if(nums.length<=1)return false;
        boolean[] dp = new boolean[nums.length];//前n个数字能不能有效划分
        dp[0] = false;
        dp[1] = nums[0]==nums[1];
        if(nums.length==2) return dp[1];
        dp[2] = (nums[0]==nums[1]&& nums[0]==nums[2]) || (nums[0]==nums[1]-1&& nums[0]==nums[2]-2);
        for(int i =2;i<dp.length-1;i++){
            dp[i+1] = (dp[i-1] && nums[i]==nums[i+1]) || (dp[i-2] && nums[i]==nums[i+1] && nums[i-1]==nums[i+1])
            ||  (dp[i-2] && nums[i]==nums[i+1]-1 && nums[i-1]==nums[i+1]-2);
        }
        return dp[dp.length-1];
    }


    public static void main(String[] args){
        System.out.println(new Solution().validPartition(new int[]{4,4,4,5,6}));
    }
}