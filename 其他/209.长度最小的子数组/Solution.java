class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length+1;
        int sum = 0;
        int left = 0;
        for(int right = 0;right<nums.length;right++){
            sum += nums[right];

            while (sum>=target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans<=nums.length?ans:0;
    }

    public static void main(String[] args){
        System.out.println(new Solution().minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}