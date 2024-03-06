import java.lang.reflect.Array;
import java.security.KeyPair;
import java.util.*;

class Solution {
    private long mod = (long) (1e9+7);
    public int countPaths(int n, int[][] roads) {
        //注意：这里是邻接图
        ArrayList<int[]>[] neighbour = new ArrayList[n];
        for(int i =0;i<neighbour.length;i++){
            neighbour[i] = new ArrayList<>();
        }
        for(int[] road:roads){
            int x = road[0];
            int y = road[1];
            int time = road[2];
            neighbour[x].add(new int[]{y,time});
            neighbour[y].add(new int[]{x,time});
        }

        long[] dis = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE/2);
        dis[0] = 0;

        long[] f = new long[n];
        f[0] = 1;

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingLong(Pair::getDx));
        queue.add(new Pair(0L,0));

        while (true){
            Pair curPair = queue.poll();
            long dx = curPair.getDx();
            int x = curPair.x;

            //初次出堆，即是最小

            if(dx > dis[x])continue;//以前出堆过

            if(x==n-1) return (int) (f[n-1]%mod);

            for(int[] nei : neighbour[x]){
                int y = nei[0];
                int time = nei[1];

                long newDir = dx + time;

                if(newDir < dis[y]){
                    dis[y] = newDir;
                    f[y] = f[x];
                    queue.add(new Pair(dis[y],y));
                } else if (newDir == dis[y]) {
                    f[y] += f[x];
                    f[y] %= mod;
                }

            }

        }

    }

    private class Pair{
        private long dx;
        private int x;
        public Pair(long dx,int x){
            this.dx = dx;
            this.x = x;
        }

        public long getDx(){
            return dx;
        }

        public int getX(){
            return x;
        }

    }



    public static void main(String[] args) {
        System.out.println(new Solution().countPaths(7,
                new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
    }

}