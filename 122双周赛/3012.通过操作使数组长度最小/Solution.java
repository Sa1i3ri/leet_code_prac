import java.util.Arrays;

class Solution {
    public int minimumArrayLength(int[] nums) {
        int n = nums.length;
        int min = Arrays.stream(nums).min().getAsInt();

        int count = 0;

        for(int i =0;i<n;i++){
            if(min == nums[i]){
                count++;
            }
        }
        if(count==1){
            return 1;
        }

        for(int i =0;i<n;i++){
            if(nums[i]%min!=0) return 1;
        }

        if((count&1)==1){
            return count/2+1;
        }else{
            return count/2;
        }


    }

    public static void main(String[] args){
        System.out.print(new Solution().minimumArrayLength(new int[]{2,3,4}));
    }
}