import javax.management.relation.RelationNotification;
import java.util.Arrays;
import java.util.Random;

class Solution {
    private int[] nums;
    private int[] origin;

    public Solution(int[] nums) {
        this.nums = new int[nums.length];
        this.origin = new int[nums.length];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);
        System.arraycopy(nums, 0, this.origin, 0, nums.length);
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        int n = nums.length;
        Random random = new Random();

        for(int i =0;i<n;i++){
            int j =  random.nextInt(n-i) + i;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;

    }



    public static void main(String[] args){
        Solution obj = new Solution(new int[]{1,2,3});



        System.out.println(obj.shuffle());
        System.out.println(obj.reset());
        System.out.println(obj.shuffle());

    }



}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
