class Solution {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = Integer.MIN_VALUE;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                res = Math.max(res,dfs(grid,i,j));
            }
        }
        return res;
    }

    private int dfs(int[][] grid,int x,int y){
        int m = grid.length;
        int n = grid[0].length;
        if(x<0 || x>m-1 || y<0 || y>n-1 || grid[x][y]!=1) return 0;

        int res = 0;

        grid[x][y] = -1;

        for(int i = 0;i<dir.length;i++){
            int cur_x = x + dir[i][0];
            int cur_y = y + dir[i][1];

            res += dfs(grid,cur_x,cur_y);

        }

        return res+1;
    }

    public static void main(String[] args){
        int[][] gird = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };
        System.out.println(new Solution().maxAreaOfIsland(gird));
    }



}