import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        int diff = max - min;

        HashMap<Integer,Integer>hashMap = new HashMap<>();
        int res = Integer.MIN_VALUE;

        for(int i = -diff;i<=diff;i++){
            hashMap.clear();

            hashMap.put(nums[0],1);
            for(int j = 1;j<nums.length;j++){
                int pre = nums[j] - i;

                if(hashMap.containsKey(pre)){
                    hashMap.put(nums[j],hashMap.get(pre)+1);
                }else{
                    hashMap.put(nums[j],1);
                }
                res = Math.max(res,hashMap.get(nums[j]));
            }

        }

        return res;

    }


    public static void main(String[] args){
        System.out.println(new Solution().longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }


}