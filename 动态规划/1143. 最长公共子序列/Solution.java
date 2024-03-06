import java.util.Arrays;

class Solution {
    private String text1;
    private String text2;
    private int[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {
//        this.text1 = text1;
//        this.text2 = text2;
//        int[][] cache = new int[text1.length()+1][text2.length()+1];
//        for(int i =0;i<cache.length;i++){
//            Arrays.fill(cache[i],-1);
//        }
//        this.cache = cache;
//        return dfs(text1.length()-1,text2.length()-1);

        int[][] cache = new int[text1.length()+1][text2.length()+1];

        for(int i =1;i<cache.length;i++){
            for(int j =1;j<cache[0].length;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    cache[i][j] = cache[i-1][j-1]+1;
                }else{
                    cache[i][j] = Math.max(cache[i-1][j-1],Math.max(cache[i-1][j],cache[i][j-1]));
                }

            }
        }

        return cache[cache.length-1][cache[0].length-1];
    }

    private int dfs(int i,int j){
        if(i<0 || j<0) return 0;
        if(cache[i][j]!=-1) return cache[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            cache[i][j] = Math.max(dfs(i-1,j-1)+1,Math.max(dfs(i-1,j),dfs(i,j-1)));
            return cache[i][j];
        }else{
            cache[i][j] = Math.max(dfs(i-1,j-1),Math.max(dfs(i-1,j),dfs(i,j-1)));
            return cache[i][j];
        }
    }
}