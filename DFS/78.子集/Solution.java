import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res,List<Integer> path,int[] nums,int index){
        if(index>=nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(res,path,nums,index+1);

        path.add(nums[index]);
        dfs(res,path,nums,index+1);
        path.remove(path.size()-1);

    }

}