import java.util.Arrays;

class Solution {
    public int findKOr(int[] nums, int k) {
        int res = 0;
        for(int i = 0;i<31;i++){
            int count = 0;
            int pow = (int) Math.pow(2,i);
            for(int num : nums){
                if((pow&num) == pow){
                    count++;
                }
                if(count>=k){
                    res += pow;
                    break;
                }
            }
        }
        return res;
    }
}