import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++){
            int count = 0;
            for(int j =i;j<nums.length;j++){
                if(nums[j]!=nums[i]){
                    i=j-1;
                    break;
                }else{
                    count++;
                }
            }
            if(count>=3) return false;
        }
        return true;

    }
    public static void main(String[] args){
        System.out.println(new Solution().isPossibleToSplit(new int[]{10,7,10,8,8,8}));
    }

}