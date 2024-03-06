class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums,target);
        if(start==nums.length || nums[start]!=target) return new int[]{-1,-1};
        return new int[]{start,binarySearch(nums,target+1)-1};
    }


    private int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = left + (right - left) /2;
            if(nums[mid]<target){
                left = mid+1;
            } else{
                right = mid-1;
            }
        }

        return left;
    }

    public static void main(String[] args){
        int[] res = new Solution().searchRange(new int[]{5,7,7,8,8,10},8);
        for(int i =0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}