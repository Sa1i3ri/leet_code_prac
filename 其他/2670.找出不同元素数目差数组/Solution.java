import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[] pre = new int[nums.length];
        for(int i =0;i<pre.length;i++){
            hashSet.add(nums[i]);
            pre[i] = hashSet.size();
        }
        hashSet.clear();
        int[] suf = new int[nums.length];
        suf[suf.length-1] = 0;
        for(int i=suf.length-2;i>=0;i--){
            hashSet.add(nums[i+1]);
            suf[i] = hashSet.size();
        }

        int[] res = new int[nums.length];
        for(int i =0;i<res.length;i++){
            res[i] = pre[i]-suf[i];
        }

        return res;


    }

    public static void main(String[] args){
        System.out.println(new Solution().distinctDifferenceArray(new int[]{37,37,37,37,33}));
    }
}