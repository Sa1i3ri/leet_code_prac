class Solution {
    public void solve(char[][] board) {

        for(int j=0;j<board[0].length;j++){
            dfs(board,0,j);
            dfs(board,board.length-1,j);
        }

        for(int i = 0;i<board.length;i++){
            dfs(board,i,0);
            dfs(board,i,board[0].length-1);
        }

        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(board[i][j]=='P'){
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j]='X';
                }
            }
        }

    }


    private void dfs(char[][] board,int x,int y){
        if(x<0 || x>=board.length || y<0 || y>=board[0].length || board[x][y]!='O') return;

        board[x][y] = 'P';

        dfs(board,x-1,y);
        dfs(board,x+1,y);
        dfs(board,x,y-1);
        dfs(board,x,y+1);


    }

    public static void main(String[] args){
        char[][] board1 = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'},
        };

        char[][] board2 = new char[][]{
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'},
        };

        char[][] board3 = new char[][]{
                {'X','O','X'},
                {'X','O','X'},
                {'X','O','X'},
        };

        char[][] board4 = new char[][]{
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','O','O'},
        };

        new Solution().solve(board4);

        for(int i =0;i<board4.length;i++){
            for(int j  =0;j<board4[0].length;j++){
                System.out.print(board4[i][j]+" ");
            }
            System.out.println();
        }

    }


}