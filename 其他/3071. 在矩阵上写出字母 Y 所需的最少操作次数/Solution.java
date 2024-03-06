import java.util.Arrays;

class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int sum = n*n;
        int res = Integer.MAX_VALUE;

        int[] yNum = new int[3];
        int[] otherNum = new int[3];

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(isInY(i,j,n)){
                    yNum[grid[i][j]]++;
                }else{
                    otherNum[grid[i][j]]++;
                }
            }
        }
        int ySum = Arrays.stream(yNum).sum();
        int otherSum = Arrays.stream(otherNum).sum();

        for(int i =0;i<otherNum.length;i++){
            for(int j = 0;j<yNum.length;j++){
                if(j==i) continue;

                int cur_res = 0;
                cur_res += otherSum - otherNum[i];
                cur_res += ySum - yNum[j];
                res = Math.min(res,cur_res);

            }
        }
        return res;

    }

    private boolean isInY(int x,int y,int n){
        int half = n/2;
        if((x==y || x== (half*2-y) ) && x<=half) return true;
        if(x>=half && y==half) return true;
        return false;
    }
}