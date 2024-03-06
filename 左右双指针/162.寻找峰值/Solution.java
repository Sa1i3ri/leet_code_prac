class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-2;

        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[mid+1]){
                left= mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;

    }

    public static void main(String[] args){
        System.out.println(new Solution().findPeakElement(new int[]{1,2,3,1}));
    }
}