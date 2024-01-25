import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long[] countOfPairs(int n, int x, int y) {
        //弗洛伊德
        long inf = Long.MAX_VALUE/2-100;
        long[][] w = new long[n+1][n+1];
        for(int i =0;i<w.length;i++){
            Arrays.fill(w[i],inf);
        }
        for(int i =1;i<w.length-1;i++){
            w[i][i]=0;
            w[i+1][i+1] = 0;
            w[i][i+1] = 1;
            w[i+1][i] = 1;
        }

        if(x!=y){
            w[x][y] = 1;
            w[y][x] = 1;
        }


        for(int k = 0;k< w.length;k++){
            //中间点
            for(int i =0;i<w.length;i++){
                //起点
                for(int j =0;j<w.length;j++){
                    //终点
                    w[i][j] = Math.min(w[i][j],w[i][k]+w[k][j]);
                }
            }
        }

        long[] res = new long[n];

        for(int i =0;i<w.length;i++){
            for(int j =0;j<i;j++){
                if(w[i][j]-1>=0 && w[i][j]-1<res.length){
                    res[(int) (w[i][j]-1)] +=2;
                }
            }
        }

        return res;

    }

    public long[] countOfPairs2(int n, int x, int y) {
        long inf = Long.MAX_VALUE/2-100;
        long[][] w = new long[n+1][n+1];
        for(int i =0;i<w.length;i++){
            Arrays.fill(w[i],inf);
        }
        for(int i =1;i<w.length-1;i++){
            w[i][i]=0;
            w[i+1][i+1] = 0;
            w[i][i+1] = 1;
            w[i+1][i] = 1;
        }

        if(x!=y){
            w[x][y] = 1;
            w[y][x] = 1;
        }


        for(int k = 0;k< w.length;k++){
            //中间点
            for(int i =0;i<w.length;i++){
                //起点
                for(int j =0;j<w.length;j++){
                    //终点
                    w[i][j] = Math.min(w[i][j],w[i][k]+w[k][j]);
                }
            }
        }

        long[] res = new long[n];

        for(int i =0;i<w.length;i++){
            for(int j =0;j<i;j++){
                if(w[i][j]-1>=0 && w[i][j]-1<res.length){
                    res[(int) (w[i][j]-1)] +=2;
                }
            }
        }

        return res;

    }



    public static void main(String[] args){
        long[] res = new Solution().countOfPairs(6,1,5);
        for(int i  =0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}