class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int sum = 1;

        int left = 0;

        if(k<=1) return 0;

        for(int right = 0;right<nums.length;right++){
            sum *= nums[right];

            while (sum>=k){
                sum/=nums[left];
                left++;
            }
            res += right-left+1;


        }
        return res;

    }

    public static void main(String[] args){
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{1,2,3,4,5},1));
    }
}