import java.io.CharArrayReader;

class Solution {
    private String word1;
    private String word2;
    private int[][] cache;
    public int minDistance(String word1, String word2) {
//        this.word1 = word1;
//        this.word2 = word2;
//        this.cache = new int[word1.length()+1][word2.length()+1];
        int[][] cache = new int[word1.length()+1][word2.length()+1];
        for(int j=0;j<cache[0].length;j++){
            cache[0][j] = j;
        }
        for(int i =0;i<cache.length;i++){
            cache[i][0] = i;
        }

        for(int i =1;i<cache.length;i++){
            for(int j =1;j<cache[0].length;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    cache[i][j] = cache[i-1][j-1];
                }else{
                    cache[i][j] = Math.min(cache[i][j-1],Math.min(cache[i-1][j],cache[i-1][j-1]))+1;
                }
            }
        }

        return cache[cache.length-1][cache[0].length-1];
        //return dfs(word1.length()-1,word2.length()-1);
    }

    private int dfs(int i,int j){

        if(i<0) return j+1;
        if(j<0) return i+1;

        if(word1.charAt(i)==word2.charAt(j)){
            return dfs(i-1,j-1);
        }else{
            return Math.min(dfs(i,j-1),Math.min(dfs(i-1,j),dfs(i-1,j-1)))+1;
        }

    }

    public static void main(String[] args){
        System.out.println(new Solution().minDistance("intention","execution"));
    }

}