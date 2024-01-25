import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        traceBack(candidates,target,res,new ArrayList<>(),0);
        return res;

    }

    private void traceBack(int[] num,int target,List<List<Integer>> res,List<Integer> path,int startIndex){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        } else if (target < 0) {
            return;
        }

        for(int i =startIndex;i<num.length;i++){
            if((i>0 && (num[i-1]==num[i] && startIndex<=i-1 ))) continue;

            path.add(num[i]);

            traceBack(num,target-num[i],res,path,i+1);

            path.remove(path.size()-1);

        }



    }

    private void dfs(int[] num,int target,List<List<Integer>> res, List<Integer> path,boolean[] used){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        } else if (target < 0) {
            return;
        }

        for(int i =0;i<num.length;i++){
            if(used[i] || (i>0 && (num[i-1]==num[i] && !used[i-1] ) || (!path.isEmpty() && num[i] < path.get(path.size()-1)))){
                continue;
            }

            used[i] = true;
            path.add(num[i]);

            dfs(num,target-num[i],res,path,used);

            path.remove(path.size()-1);
            used[i] = false;


        }

    }

    public static void main(String[] args){
        int[] num = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(new Solution().combinationSum2(num,target));
    }

}