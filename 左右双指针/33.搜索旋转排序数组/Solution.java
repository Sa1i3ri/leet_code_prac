class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int last = nums[nums.length-1];
        //闭区间
        while (left<=right){
            int mid = left + (right-left)/2;
            int cur = nums[mid];
            if( (cur<target && cur<=last && target<=last) || (cur<target && cur>last && target>last ) || (cur>last && target<=last) ){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return nums[left]==target?left:-1;
    }

    public static void main(String[] args){
        System.out.println(new Solution().search(new int[]{1,3},3));
    }

}