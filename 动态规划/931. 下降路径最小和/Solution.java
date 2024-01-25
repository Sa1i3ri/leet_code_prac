class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] result = new int[2][matrix[0].length];
        for(int j =0;j<matrix[0].length;j++){
            result[0][j] = matrix[0][j];
        }

        for(int i = 1;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(j==0){
                    result[i&1][j] = matrix[i][j] +  Math.min(result[(i-1)&1][j],result[(i-1)&1][j+1]);
                } else if (j == matrix[0].length-1) {
                    result[i&1][j] = matrix[i][j] +   Math.min(result[(i-1)&1][j],result[(i-1)&1][j-1]);
                }else{
                    result[i&1][j] = matrix[i][j] +   Math.min(Math.min(result[(i-1)&1][j],result[(i-1)&1][j+1]),result[(i-1)&1][j-1]) ;
                }
            }
        }
        int minResult = Integer.MAX_VALUE;

        for(int j = 0;j<matrix[0].length;j++){
            minResult = Math.min(minResult,result[(matrix.length-1)&1][j]);
        }
        return minResult;

    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(new Solution().minFallingPathSum(matrix));
    }
}
