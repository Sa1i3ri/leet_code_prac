import java.util.*;

public class Solution1 {
    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] out = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                for(int k = 0;k<dir.length;k++){
                    int cur_x = i + dir[k][0];
                    int cur_y = j + dir[k][1];
                    if(cur_x>=0 && cur_y>=0 && cur_x<m && cur_y<n && matrix[cur_x][cur_y] > matrix[i][j]){
                        out[i][j] ++;
                    }
                }
            }
        }

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(out[i][j]==0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int deep = 0;

        while (!queue.isEmpty()){
            deep++;

            int temp = queue.size();

            for(int i =0;i<temp;i++){
                int[] curPoint = queue.poll();
                int x = curPoint[0];
                int y = curPoint[1];

                for(int k = 0;k<dir.length;k++){
                    int cur_x = x + dir[k][0];
                    int cur_y = y + dir[k][1];

                    if(cur_x>=0 && cur_y>=0 && cur_x<m && cur_y<n && matrix[cur_x][cur_y] < matrix[x][y]){
                        out[cur_x][cur_y]--;
                        if(out[cur_x][cur_y]==0){
                            queue.add(new int[]{cur_x,cur_y});
                        }
                    }

                }

            }

        }

        return deep;
    }


    public static void main(String[] args){
        int[][] matrix1 = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix2 = new int[][]{{3,4,5},{3,2,6},{2,2,1}};
        int[][] matrix3 = new int[][]{{1,2},{2,3}};
        System.out.println(new Solution1().longestIncreasingPath(matrix2));
    }

}
