import java.util.Scanner;

public class Solution {

    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    private int operate(int[][] map){
        int mod = 998244353;
        int n = map.length;
        int m = map[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(map[i][j]==1) continue;
                for(int k =0;k<dir.length;k++){
                    int cur_x = i + dir[k][0];
                    int cur_y = j + dir[k][1];
                    if(cur_x>=0 && cur_x<n && cur_y>=0 && cur_y<m){
                        dp[i][j] += dp[cur_x][cur_y];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return dp[n-1][m-1];


    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int i =0;i<num;i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int j = scanner.nextInt();
            int[][] map = new int[n][m];
            for(int p =0;p<k;p++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                map[x-1][y-1] = 1;
            }
            System.out.println(new Solution().operate(map));
        }
    }
}
