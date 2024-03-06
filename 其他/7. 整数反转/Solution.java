import java.util.Arrays;

class Solution {

    private int[] v;
    private int[] w;
    private int[][] cache;

    public int zeroOnePacket(int[] v,int[] w,int capacity){
        this.v = v;
        this.w = w;
        this.cache = new int[v.length][capacity];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        return dfs(v.length-1,capacity);
    }
    /**
     *
     * @param i 所有能选的物品的下标最大值，也是当前要选择拿或不拿的物品
     * @param c 背包剩余c容量
     * @return 在选到第i个物品，且背包使用容量不超过c时，最多能获得多少钱
     */
    public int dfs(int i,int c){
        if(i<0) return 0;//没东西可选
        if(cache[i][c]!=-1) return cache[i][c];//cache有所需要的数据
        if(c<w[i]){
            cache[i][c] =dfs(i-1,c);//剩余容量太小，选不了i
            return cache[i][c];
        }
        cache[i][c] = Math.max(dfs(i-1,c),dfs(i-1,c-w[i])+v[i]);//在拿和不拿中选赚最多的
        return cache[i][c];
    }
}