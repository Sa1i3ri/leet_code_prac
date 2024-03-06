import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i =0;i<nums.length-2;i++){
            int x = nums[i];
            if(i>0 && x==nums[i-1]) continue;
            if(x+nums[nums.length-1]+nums[nums.length-2]<0) continue;
            if(x+nums[i+1]+nums[i+2]>0) break;

            int j = i+1;
            int k = nums.length-1;

            while (j<k){
                int y = nums[j];
                int z = nums[k];
                if(x+y+z>0){
                    k--;
                } else if (x + y + z < 0) {
                    j++;
                }else{
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                    res.add(temp);
                    j++;
                    k--;

                    while (j<nums.length-1 &&  nums[j]==y){
                        j++;
                    }
                    while (k<nums.length-1&& nums[k]==z){
                        k++;
                    }

                }
            }

        }
        return res;
    }

    public static void main(String[] args){
        new Solution().threeSum(new int[]{0,0,0});
    }
}