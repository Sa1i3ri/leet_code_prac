class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-2;
        //闭区间
        while (left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid]>nums[nums.length-1]){
                //在最小点的左边
                left = mid+1;
            }else{
                right = mid-1;
            }

        }
        return nums[left];
    }

    public static void main(String[] args){
        System.out.println(new Solution().findMin(new int[]{3,4,5,1,2}));
    }
}