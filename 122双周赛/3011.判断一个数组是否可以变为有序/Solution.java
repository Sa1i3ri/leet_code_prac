import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean canSortArray(int[] nums) {
        //从数字到下标
        HashMap<Integer, Integer> reverse = new HashMap<>();
        int[] copy = new int[nums.length];

        System.arraycopy(nums,0,copy,0,nums.length);

        Arrays.sort(copy);

        for(int i =0;i<copy.length;i++){
            int toPlace = reverse.getOrDefault(copy[i],-1);
            reverse.put(copy[i],Math.max(toPlace,i));
        }

        int max = Arrays.stream(nums).max().getAsInt();
        int[] table = new int[max+1];
        table[0]=0;
        if(max>1) table[1]=1;
        for(int i =2;i<max+1;i++){
            if((i&1)==1){
                table[i] = 1+table[(i-1)/2];
            }else{
                table[i] = table[i/2];
            }
        }


        for(int i =0;i<nums.length;i++){
            int toPlace = reverse.get(nums[i]);
            if(toPlace>i){
                boolean judge = true;
                for(int j =i+1;j<=toPlace;j++){
                    if(table[nums[i]] != table[nums[j]]){
                        judge=false;
                        break;
                    }
                }
                if(!judge) return false;
            }

        }
        return true;

    }


    public static void main(String[] args){
        System.out.print(new Solution().canSortArray(new int[]{8,4,2,30,15}));
    }


}