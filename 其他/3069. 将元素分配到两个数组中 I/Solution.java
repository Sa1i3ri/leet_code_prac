import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(nums[0]);
        list2.add(nums[1]);

        for(int i=2;i<nums.length;i++){
            List<Integer> cur = list1.get(list1.size()-1) > list2.get(list2.size()-1) ? list1:list2;
            cur.add(nums[i]);
        }
        list1.addAll(list2);

        int[] res = new int[nums.length];
        for(int i =0;i<list1.size();i++){
            res[i] = list1.get(i);
        }
        return res;

    }
}