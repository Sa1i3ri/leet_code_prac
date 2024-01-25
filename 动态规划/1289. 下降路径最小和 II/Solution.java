class Solution {
    public int minFallingPathSum(int[][] grid) {
        //第一个数字：最小的下标，第二个数字：次小的下标
        int[][] result = new int[2][grid[0].length];
        System.arraycopy(grid[0], 0, result[0], 0, result[0].length);

        int[][] minIndex = new int[2][2];
        minIndex[0][0] = getMinIndex(result[0],-1);
        minIndex[0][1] = getMinIndex(result[0],minIndex[0][0]);

        for(int i = 1;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                result[i&1][j] = j!=minIndex[(i-1)&1][0]? grid[i][j] + result[(i-1)&1][minIndex[(i-1)&1][0]] :
                        grid[i][j] + result[(i-1)&1][minIndex[(i-1)&1][1]];
            }
            minIndex[i&1][0] = getMinIndex(result[i&1],-1);
            minIndex[i&1][1] = getMinIndex(result[i&1],minIndex[i&1][0]);
        }

        int minResult = Integer.MAX_VALUE;
        for(int j = 0;j<result[0].length;j++){
            minResult = Math.min(minResult,result[(grid.length-1)&1][j]);
        }
        return minResult;


    }

    private int getMinIndex(int[] grid,int exceptIndex){
        int index = 0!=exceptIndex? 0:grid.length-1;
        for(int i = 0;i<grid.length;i++){
            if(grid[i] < grid[index] && i!=exceptIndex){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2}};
        System.out.println(new Solution().minFallingPathSum(grid));
    }




}