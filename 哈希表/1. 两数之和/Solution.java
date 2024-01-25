import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            for(int j =0;j<nums.length && j!=i;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;

    }
}

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(!hashMap.containsKey(target-nums[i])){
                hashMap.put(nums[i],i);
            }else{
                return new int[]{hashMap.get(target-nums[i]),i};
            }
        }
        return null;

    }
    public static void main(String args[]){
        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(solution2.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}