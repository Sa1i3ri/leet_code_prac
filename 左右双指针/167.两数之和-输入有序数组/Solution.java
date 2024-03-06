class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (left<right){
            int x = numbers[left];
            int y = numbers[right];
            if(x+y<target){
                left++;
            } else if (x + y > target) {
                right--;
            }else{
                return new int[]{left+1,right+1};
            }
        }
        return null;
    }
}