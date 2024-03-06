import java.util.Arrays;

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int res = 0;
        int[][] sum = new int[grid.length+1][grid[0].length+1];
        for(int i =1;i<sum.length;i++){
            for(int j =1;j<sum[0].length;j++){
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + grid[i-1][j-1];
                if(sum[i][j]<=k) res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countSubmatrices(new int[][]{{7,6,3},{6,6,1}}, 18));
    }

}