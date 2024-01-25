class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = 1000000007;
        int[][][] cache = new int[m][n][maxMove+1];

        for(int j=0;j<n;j++){
            cache[0][j][1]+=1;
            cache[m-1][j][1] +=1;
        }
        for(int i =0;i<m;i++){
            cache[i][0][1]+=1;
            cache[i][n-1][1]+=1;
        }

        for(int curMove = 2;curMove<cache[0][0].length;curMove++){
            for(int ix = 0;ix<m;ix++){
                for(int iy = 0;iy<n;iy++){

                }
            }
        }
        int res = 0;
        for(int i =1;i<cache[0][0].length;i++){
            res += cache[startRow][startColumn][i];
            res %= mod;
        }
        return cache[startRow][startColumn][maxMove];


    }


    public static void main(String[] args){
        System.out.println(new Solution().findPaths(2,3,8,1,0));
    }
}