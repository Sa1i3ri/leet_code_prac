class Solution {
    public int numberOfArrays(String s, int k) {
        int mod = 1000000007;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = Integer.parseInt(s.charAt(0)+"") <= k ? 1:0;

        for(int i =1;i<n;i++){
            String pre = s.substring(0,i);

            for(int j =i;j>=0;j--){
                if(i-j >9 || Long.parseLong(pre.substring(j) + s.charAt(i))>k) break;
                String curString = pre.substring(j) + s.charAt(i);
                if(curString.startsWith("0")) continue;
                if(Integer.parseInt(curString) <=k){
                    if(j==0){
                        dp[i]+=1;
                    }else{
                        dp[i]+=dp[j-1];
                    }
                    dp[i] %= mod;
                }
            }

        }

        return dp[n-1];

    }

    public static void main(String[] args){
        System.out.println(new Solution().numberOfArrays("1234567890" ,90));
    }


}