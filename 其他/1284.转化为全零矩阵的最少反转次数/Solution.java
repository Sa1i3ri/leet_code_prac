import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

class Solution {
    public int minFlips(int[][] mat) {
        int res = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        int curNum = encode(mat);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(curNum);


        while (!queue.isEmpty()){
            int k = queue.size();
            for(int t =0;t<k;t++){
                curNum = queue.poll();
                int[][] curMat = decode(curNum,mat.length,mat[0].length);
                if(curNum==0) return res;
                hashSet.add(curNum);

                for(int i =0;i<mat.length;i++){
                    for(int j =0;j<mat[0].length;j++){
                        int newNum = encode(operate(curMat,i,j));
                        if(!hashSet.contains(newNum)){
                            queue.add(newNum);
                            hashSet.add(newNum);
                        }
                    }
                }

            }


            res++;
        }

        return -1;
    }

    private int encode(int[][] mat){
        int res = 0;
        for(int i =0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                res = res * 2 + mat[i][j];
            }
        }
        return res;
    }

    private int[][] decode(int code,int m,int n){
        int[][] res = new int[m][n];

        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                res[i][j] = code & 1;
                code/=2;
            }
        }

        return res;
    }

    private int[][] operate(int[][] mat,int x,int y){
        int[][] res = new int[mat.length][mat[0].length];

        for(int i =0;i<res.length;i++){
            for(int j =0;j<res[0].length;j++){
                if( (i==x && j==y) || (x > 0 && i==x-1 && j==y) || (y > 0 && i==x && j==y-1) ||
                        (x < res.length-1 && i==x+1 && j==y) || (y< res[0].length-1 && i==x && j==y+1)){
                    res[i][j] = mat[i][j]==1?0:1;
                }else{
                    res[i][j] = mat[i][j];
                }
            }
        }
        return res;

    }

    public static void main(String[] args){
        int[][] mat1 = new int[][]{{0,0},{0,1}};
        int[][] mat2 = new int[][]{{1}};
        int[][] mat3 = new int[][]{{1,0,0},{1,0,0}};
        System.out.println(new Solution().minFlips(mat3));
    }


}