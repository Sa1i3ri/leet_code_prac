import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<triangle.size();i++){
            result.add(new LinkedList<>());
            for(int j = 0;j<triangle.get(i).size();j++){
                result.get(i).add(0);
            }
        }
        result.get(0).set(0,triangle.get(0).get(0));



        for(int i =1;i<result.size();i++){
            for(int j  =0;j<result.get(i).size();j++){
                if(j==0){
                    result.get(i).set(j,triangle.get(i).get(j) + result.get(i-1).get(j));
                } else if (j == i) {
                    result.get(i).set(j,triangle.get(i).get(j) +result.get(i-1).get(j-1));
                }else{
                    result.get(i).set(j,triangle.get(i).get(j) + Math.min(result.get(i-1).get(j),result.get(i-1).get(j-1)));
                }
            }
        }

        int minResult = Integer.MAX_VALUE;
        for(int i =0;i<result.get(result.size()-1).size();i++){
            minResult = Math.min(minResult,result.get(result.size()-1).get(i));
        }
        return minResult;

    }


    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(2);
        triangle.add(new ArrayList<>());
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.add(new ArrayList<>());
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.add(new ArrayList<>());
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);

        System.out.println(new Solution().minimumTotal(triangle));
    }
}