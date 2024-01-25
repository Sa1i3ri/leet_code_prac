import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size();
        int[] table = new int[n];
        table[0]=0;
        if(n>=2) table[1]=1;
        for(int i = 2;i<n;i++){
            if((i&1)==1){
                table[i] = 1 + table[(i-1)/2];
            }else{
                table[i] = table[i/2];
            }
        }
        int res = 0;
        for(int i =0;i<n;i++){
            if(table[i]==k) res+=nums.get(i);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.print(new Solution().sumIndicesWithKSetBits(new ArrayList<>(Arrays.asList(5,10,1,5,2,1,4,2,43,2)),1));
    }

}