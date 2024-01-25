import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> num = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i =1;i<=n;i++){
            num.add(i);
        }

        TraceBack(res,new ArrayDeque<>(), num, k, 0);

        return res;


    }

    private void TraceBack(List<List<Integer>> res, Deque<Integer> path, List<Integer> num, int k, int startIndex){
        if(k==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex;i<num.size();i++){
            int curNum = num.get(i);

            path.addLast(curNum);

            TraceBack(res,path,num,k-1,i+1);

            path.removeLast();

        }
    }


    public static void main(String[] args){
        System.out.println(new Solution().combine(4,2));
    }
}