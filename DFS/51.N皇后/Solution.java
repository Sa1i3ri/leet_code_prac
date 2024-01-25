import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<String> path= new ArrayList<>();

        for(int i =0;i<n;i++){
            StringBuilder cur = new StringBuilder();
            for(int j =0;j<n;j++){
                cur.append('.');
            }
            path.add(cur.toString());
        }

        List<List<String>> res = new ArrayList<>();
        dfs(res,path,0,n,0,0);

        return res;

    }

    private void dfs(List<List<String>> res,List<String> path,int count,int n,int x,int y){
        if(count == n){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){

                if(i != count) continue;

                if(isLegal(path,i,j,n) && (i>x || (i==x && j>=y))){
                    StringBuilder curCol = new StringBuilder(path.get(i));
                    curCol.setCharAt(j,'Q');
                    path.set(i,curCol.toString());

                    dfs(res,path,count+1,n,i,j);

                    curCol.setCharAt(j,'.');
                    path.set(i,curCol.toString());
                }
            }
        }

    }

    private boolean isLegal(List<String> path,int x,int y,int n){
        //横竖
        for(int i =0;i<n;i++){
            char cur1 = path.get(i).charAt(y);
            char cur2 = path.get(x).charAt(i);

            int x1 = x + i;
            int y1 = y + i;

            int x2 = x-i;
            int y2 = y-i;

            if( (i!=x && cur1=='Q') || (i!=y && cur2=='Q' ) || (x1 < n && y1 < n && path.get(x1).charAt(y1) == 'Q') ||
                    (x2>=0 && y2>=0 && path.get(x2).charAt(y2)=='Q') || (x1<n && y2>=0 && path.get(x1).charAt(y2)=='Q') ||
                    (x2>=0 && y1<n && path.get(x2).charAt(y1) == 'Q')){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int n = 9;
        List<List<String>> res = new Solution().solveNQueens(n);
        for(int i =0;i<res.size();i++){
            for(int j = 0;j<n;j++){
                System.out.println(res.get(i).get(j));
            }
            System.out.println();
        }
    }


}