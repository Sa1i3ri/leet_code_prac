class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        result[0][0]=1;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    result[i][j]=0;
                    continue;
                }
                if(i>0 && j>0){
                    result[i][j] =  result[i][j-1] + result[i-1][j];
                } else if (i > 0) {
                    result[i][j] = result[i-1][j];
                } else if (j > 0) {
                    result[i][j] =  result[i][j-1];
                }
            }
        }

        return result[m-1][n-1];
    }


    public static void main(String[] args){
        int[][] grid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new Solution().uniquePathsWithObstacles(grid));
    }
}
