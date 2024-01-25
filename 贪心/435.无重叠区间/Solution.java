import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int m = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });

        int index = 0;
        int res = 1;


        for(int i =1;i<m;i++){
            if(intervals[i][0] >= intervals[index][1]){
                index = i;
                res++;
            }
        }

        return m - res;

    }

    public static void main(String[] args){
        int[][] intervals = new int[][]{{1,100},{11,22},{1,11},{2,12}};

        System.out.println(new Solution().eraseOverlapIntervals(intervals));

    }

}