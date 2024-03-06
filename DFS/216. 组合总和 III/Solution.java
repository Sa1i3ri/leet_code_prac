import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),k,n,0,1);
        return res;
    }
    private void dfs(List<List<Integer>> res,List<Integer> path,int k,int n,int curSum,int num){
        if(curSum>n || num>10) return;
        if(path.size()==k){
            if(curSum==n){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i =num;i<=9;i++){
            path.add(i);
            dfs(res,path,k,n,curSum+i,i+1);
            path.remove(path.size()-1);
        }

    }
}