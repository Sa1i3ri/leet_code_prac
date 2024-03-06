class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long max = 0;

        for(int i =0;i<bottomLeft.length-1;i++){
            int[] curLeft1 = bottomLeft[i];
            int[] curRight1 = topRight[i];
            for(int j =i+1;j< bottomLeft.length;j++){
                int[] curLeft2 = bottomLeft[j];
                int[] curRight2 = topRight[j];

                int[] resultLeft = new int[]{Math.max(curLeft1[0],curLeft2[0]),Math.max(curLeft1[1],curLeft2[1])};
                int[] resultRight = new int[]{Math.min(curRight1[0],curRight2[0]),Math.min(curRight1[1],curRight2[1])};

                long len = Math.min(resultRight[0]-resultLeft[0],resultRight[1]-resultLeft[1]);
                if(len<0) continue;
                max = Math.max(max,len *len);

            }
        }
        return max;
    }
}