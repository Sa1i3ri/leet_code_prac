import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        if(image.length==0 || image[0].length==0 ) return null;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr,sc});
        int oldColor = image[sr][sc];

        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            if( x<0 || y<0 || x>=image.length || y>=image[0].length || image[x][y]!= oldColor || image[x][y] == color) continue;;
            image[x][y] = color;
            queue.add(new int[]{x-1,y});
            queue.add(new int[]{x+1,y});
            queue.add(new int[]{x,y-1});
            queue.add(new int[]{x,y+1});

        }

        return image;

    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        if(image.length==0 || image[0].length==0 || image[sr][sc]==color) return image;
        dfs(image,sr,sc,image[sr][sc],color);
        return image;
    }

    private void dfs(int[][] image,int x,int y,int oldColor,int color){
        if(x<0 || y<0 || x>=image.length || y>= image[0].length || image[x][y]!=oldColor) return;
        image[x][y] = color;

        dfs(image,x-1,y,oldColor,color);
        dfs(image,x+1,y,oldColor,color);
        dfs(image,x,y-1,oldColor,color);
        dfs(image,x,y+1,oldColor,color);

    }

    public static void main(String[] args){
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};

        image = new Solution().floodFill2(image,1,1,2);

        for(int i =0;i<image.length;i++){
            for (int j =0;j<image[0].length;j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

    }




}