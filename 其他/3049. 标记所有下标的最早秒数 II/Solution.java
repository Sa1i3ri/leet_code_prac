import java.util.Arrays;
import java.util.HashSet;

class Solution {
    private int[] nums;
    private int[] changeIndices;
    private int[] last;
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        this.nums = nums;
        this.changeIndices = changeIndices;
        this.last = new int[nums.length];

        int left = 1;
        int right = changeIndices.length;

        int mid;

        while (left <= right){
            mid = left + (right-left)/2;

            if(check(mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left<=changeIndices.length?left:-1;
    }

    private boolean check(int days){
        Arrays.fill(last,-1);
        for(int i =0;i<days;i++){
            last[changeIndices[i]-1] = i;
        }
        for(int num:last){
            if(num==-1) return false;
        }

        int remain =0;

        for(int i =0;i<days;i++){
            int index = changeIndices[i]-1;
            if(i==last[index]){
                if(remain<nums[index]){
                    return false;
                }else{
                    remain -= nums[index];
                }
            }else{
                remain++;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new Solution().earliestSecondToMarkIndices(new int[]{1,3},new int[]{1,1,1,2,1,1,1}));
    }

}