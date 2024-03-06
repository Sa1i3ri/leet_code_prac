import java.util.Arrays;

class Solution {
    private int[] coins;
    private int[][] cache;
    public int coinChange(int[] coins, int amount) {
        //this.coins = coins;
        int[][] cache = new int[coins.length+1][amount+1];
//        this.cache = cache;
//        for(int i =0;i<cache.length;i++){
//            Arrays.fill(cache[i],-1);
//        }
//        int res = dfs(coins.length-1,amount);
//        if(res>1e4) return -1;
//        return res;

        Arrays.fill(cache[0], Integer.MAX_VALUE / 2);
        cache[0][0] = 0;

        for(int i=1;i<cache.length;i++){
            int num = coins[i-1];
            for(int c=0;c<cache[0].length;c++){
                if(c<coins[i-1]){
                    cache[i][c] = cache[i-1][c];
                }else{
                    cache[i][c] = Math.min(cache[i-1][c],cache[i][c-num]+1);
                }
            }
        }
        return cache[cache.length-1][cache[0].length-1]>1e4?-1:cache[cache.length-1][cache[0].length-1];

    }

    private int dfs(int i,int amount){
        if(i<0) return amount==0?0:Integer.MAX_VALUE/2;
        if(cache[i][amount]!=-1) return cache[i][amount];
        if(amount < coins[i]) {
            cache[i][amount] = dfs(i - 1, amount);
            return cache[i][amount];
        }

        cache[i][amount] = Math.min(dfs(i-1,amount),dfs(i,amount-coins[i])+1);
        return cache[i][amount];

    }


}