import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res,new StringBuilder(),n,0);
        return res;
    }

    private void dfs(List<String> res,StringBuilder path,int n,int left){
        if(path.length()==2*n){
            res.add(path.toString());
            return;
        }
        if(left<n) {
            path.append('(');
            dfs(res, path, n, left + 1);
            path.deleteCharAt(path.length()-1);
        }

        if(path.length()-left < left){
            path.append(')');
            dfs(res,path,n,left);
            path.deleteCharAt(path.length()-1);
        }

    }

    public static void main(String[] args){
        List<String> res = new Solution().generateParenthesis(3);
        for(int i =0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

}