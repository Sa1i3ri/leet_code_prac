class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        result[0][0] = grid[0][0];

        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i>0 && j>0){
                    result[i][j] = Math.min(result[i-1][j] , result[i][j-1]) +grid[i][j];
                } else if (i > 0) {
                    result[i][j] = result[i-1][j] + grid[i][j];
                } else if (j > 0) {
                    result[i][j] = result[i][j-1] + grid[i][j];
                }
            }
        }

        return result[m-1][n-1];
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Solution().minPathSum(grid));
    }
}