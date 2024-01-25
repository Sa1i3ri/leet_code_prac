class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int[][] dp = new int[arr.length][2];
        dp[0][0] = (arr[0]&1)==1?1:0;
        dp[0][1] = dp[0][0]==1?0:1;
        for(int i =1;i<arr.length;i++){
            int cur = arr[i]&1;
            if(cur==1){
                //为奇
                dp[i][0] = dp[i-1][1] + 1;
                dp[i][1] = dp[i-1][0];
            }else{
                //为偶
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1]+1;
            }
            dp[i][0]%=mod;
            dp[i][1]%=mod;
        }
        int res = 0;
        for(int i =0;i<dp.length;i++){
            res += dp[i][0];
            res%=mod;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new Solution().numOfSubarrays(new int[]{7}));
    }



}