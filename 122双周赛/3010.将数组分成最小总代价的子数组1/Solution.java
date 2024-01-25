class Solution {
    public int minimumCost(int[] nums) {
        int res = 0;
        int min = -1;
        int min2 = -1;

        for(int i = 1;i<nums.length;i++){
            if(min==-1||nums[i] < nums[min]){
                min = i;
            }
        }
        for(int i = 1;i<nums.length;i++){
            if(i==min) continue;
            if(min2==-1||nums[i] < nums[min2]){
                min2 = i;
            }
        }
        return nums[0] + nums[min] + nums[min2];

    }
    public static void main(String[] args){
        System.out.print(new Solution().minimumCost(new int[]{2,3,5,2,1,4}));
    }
}