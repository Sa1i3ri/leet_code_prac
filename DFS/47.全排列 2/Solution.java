import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }

        boolean[] used = new boolean[len];
        Arrays.fill(used,false);

        dfs(res,nums,used,new ArrayList<>(),0);

        return res;

    }

    private void dfs(List<List<Integer>> res,int[] num,boolean[] used,List<Integer> curPath,int depth){
        if(depth == num.length){
            res.add(new ArrayList<>(curPath));
            return;
        }

        for(int i = 0;i<num.length;i++){
            if(used[i] || ( i > 0 && (num[i] == num[i-1] && !used[i-1]))){
                continue;
            }

            curPath.add(num[i]);
            used[i] = true;

            dfs(res,num,used,curPath,depth+1);

            used[i] = false;
            curPath.remove(curPath.size()-1);
        }
    }


    public static void main(String[] args){
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }
}