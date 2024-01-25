import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates,target,res,new ArrayList<>());

        return res;

    }

    private void dfs(int[] num,int target,List<List<Integer>> res,List<Integer> curPath){
        if(getSum(curPath)==target){
            res.add(new ArrayList<>(curPath));
            return;
        } else if (getSum(curPath) > target) {
            return;
        }

        int curSum = getSum(curPath);

        for (int j : num) {
            if(!curPath.isEmpty() && j<curPath.get(curPath.size()-1) ){
                continue;
            }


            curPath.add(j);

            dfs(num, target, res, curPath);

            curPath.remove(curPath.size() - 1);

        }


    }

    private int getSum(List<Integer> curPath){
        int sum = 0;
        for (Integer integer : curPath) {
            sum += integer;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] num = {2,3,5};
        int target = 8;

        System.out.println(new Solution().combinationSum(num,target));

    }
}