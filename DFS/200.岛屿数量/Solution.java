import java.util.Arrays;

class Solution {
    public int numIslands1(char[][] grid) {

        int result = 0;

        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid,int x,int y){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]!='1') return;

        grid[x][y] = '2';

        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);

    }



    public static void main(String[] args){
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };

        System.out.println(new Solution().numIslands1(grid));

    }

}