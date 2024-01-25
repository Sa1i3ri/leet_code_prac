class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int[][] res = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                res[i][j] =2* row[i]+ 2* col[j] -m-n;
            }
        }

        return res;
    }


    public static void main(String[] args){
        int[][] grid = new int[][]{{0,1,1},{1,0,1},{0,0,1}};
        int[][] res = new Solution().onesMinusZeros(grid);
        for(int i =0;i<res.length;i++){
            for(int j =0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}