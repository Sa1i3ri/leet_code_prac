import java.util.*;

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long res = Long.MIN_VALUE+100;

        Stack<Long> stack1 = new Stack<>();
        Stack<Long> stack2 = new Stack<>();
        long cur;

        long[] pre = new long[n];
        long[] suf = new long[n];

        pre[0] = maxHeights.get(0);
        suf[n-1] = maxHeights.get(n-1);
        stack1.push(pre[0]);
        stack2.push(suf[n-1]);

         for(int i = 1;i<n;i++){
            cur = maxHeights.get(i);
            long toPlus = 1;
            while (!stack1.isEmpty()&&stack1.peek() > cur){
                pre[i] -= stack1.pop();
                toPlus++;
            }
            for(int j =0;j<toPlus;j++){
                stack1.push(cur);
            }
            pre[i] += pre[i-1]+toPlus*cur;
        }

        for(int i =n-2;i>=0;i--){
            cur = maxHeights.get(i);
            long toPlus = 1;
            while (!stack2.isEmpty() && stack2.peek() > cur){
                suf[i] -= stack2.pop();
                toPlus++;
            }
            for(int j =0;j<toPlus;j++){
                stack2.push(cur);
            }
            suf[i] += suf[i+1]+toPlus*cur;
        }
        for(int i =0;i<n;i++){
            res = Math.max(res,(long)pre[i]+suf[i]-maxHeights.get(i));
        }

        return res;
    }

    public static void main(String[] args){
        int[] temp = new int[]{6,5,3,9,2,7};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1000000000,999999999,999999998));
        System.out.print(new Solution().maximumSumOfHeights(list));
    }


}