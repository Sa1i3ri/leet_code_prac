class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(dfs(board,i,j,word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,int x,int y,String words){
        if(words.isEmpty())return true;
        char word = words.charAt(0);
        if(x<0 || y<0 || x>=board.length|| y>= board[0].length || board[x][y]!=word) return false;

        board[x][y] = '1';


        boolean result =  dfs(board,x-1,y,words.substring(1))||
                dfs(board,x+1,y,words.substring(1))||
                dfs(board,x,y-1,words.substring(1))||
                dfs(board,x,y+1,words.substring(1));

        board[x][y] = word;

        return result;
    }

    public static void main(String[] args){
        char[][] board1 = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };

        char[][] board2 = new char[][]{
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'},
        };


        System.out.println(new Solution().exist(board1,"ABCCED"));
        System.out.println(new Solution().exist(board2,"AABD"));
    }

}