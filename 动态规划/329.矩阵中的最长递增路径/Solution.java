import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max_step = m*n;
        //坐标x,y。最多走几步
        int[][] cache = new int[m][n];
        for(int i =0;i<cache.length;i++){
            Arrays.fill(cache[i],-1);
        }

        boolean[][] used = new boolean[m][n];
        for(int i = 0;i<used.length;i++){
            Arrays.fill(used[i],false);
        }

        int ans = -1;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                List<int[]> path = new ArrayList<>();
                path.add(new int[]{i,j});
                used[i][j] = true;
                ans = Math.max(ans,dfs(matrix,cache,used,path));
                used[i][j] = false;
            }
        }


        return ans;
    }

    private int dfs(int[][] matrix, int[][] cache, boolean[][] used, List<int[]> path){
        int m = matrix.length;
        int n = matrix[0].length;

        int x = path.get(path.size()-1)[0];
        int y = path.get(path.size()-1)[1];

        if(!isRoad(matrix,used,x,y)) return 1;
        if(cache[x][y]!=-1) return cache[x][y];

        int r1 = Integer.MIN_VALUE;
        int r2 = Integer.MIN_VALUE;
        int r3 = Integer.MIN_VALUE;
        int r4 = Integer.MIN_VALUE;

        if(x!=0 && matrix[x-1][y] > matrix[x][y]){
            path.add(new int[]{x-1,y});
            used[x-1][y] = true;
            r1 = dfs(matrix,cache,used,path);
            path.remove(path.size()-1);
            used[x-1][y] = false;
        }

        if(x!=m-1 && matrix[x+1][y] > matrix[x][y]){
            path.add(new int[]{x+1,y});
            used[x+1][y] = true;
            r2 = dfs(matrix,cache,used,path);
            path.remove(path.size()-1);
            used[x+1][y] = false;
        }

        if(y!=0 && matrix[x][y-1] > matrix[x][y]){
            path.add(new int[]{x,y-1});
            used[x][y-1] = true;
            r3 = dfs(matrix,cache,used,path);
            path.remove(path.size()-1);
            used[x][y-1] = false;
        }

        if(y!=n-1 && matrix[x][y+1] > matrix[x][y]){
            path.add(new int[]{x,y+1});
            used[x][y+1] = true;
            r4 = dfs(matrix,cache,used,path);
            path.remove(path.size()-1);
            used[x][y+1] = false;
        }

        cache[x][y] = Math.max(Math.max(r1,r2),Math.max(r3,r4))+1;
        return cache[x][y];


    }

    private boolean isRoad(int[][] matrix,boolean[][] used,int x,int y){
        if(x<0 || y<0 || x>matrix.length-1|| y>matrix[0].length-1) return false;

        int x1 = Math.max(0,x-1);
        int x2 = Math.min(matrix.length-1,x+1);
        int y1 = Math.max(0,y-1);
        int y2 = Math.min(matrix[0].length-1,y+1);

        return (matrix[x1][y] > matrix[x][y] && !used[x1][y]) || (matrix[x2][y] > matrix[x][y] && !used[x2][y]) ||
                (matrix[x][y1] > matrix[x][y] && !used[x][y1]) || (matrix[x][y2] > matrix[x][y] && !used[x][y2]);

    }

    public static void main(String[] args){
        int[][] matrix1 = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix2 = new int[][]{{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(new Solution().longestIncreasingPath(matrix2));
    }




}