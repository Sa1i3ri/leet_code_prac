class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i =0;i<s.length();i++){
            dp[i][i] = true;
        }
        for(int i =0;i<s.length()-1;i++){
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }

        for(int i = s.length()-1;i>=0;i--){
            for(int j =0;j<s.length();j++){
                if(j<i) {
                    dp[i][j] = false;
                } else if (i < j-1) {
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int x=0,y =0;

        for(int i =0;i<s.length();i++){
            for(int j = i;j<s.length();j++){
                if(j-i+1 > max && dp[i][j]){
                    x=i;
                    y=j;
                    max = j-i+1;
                }
            }
        }
        return s.substring(x,y+1);

    }


    public static void main(String[] args){
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }


}