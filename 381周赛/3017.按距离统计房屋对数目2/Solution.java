import java.awt.print.PrinterGraphics;

class Solution {
    public long[] countOfPairs(int n, int x, int y) {
        long[] res = new long[n];
        int left = Math.min(x,y);
        int right = Math.max(x,y);




    }

    private long line(int x,int d,int n){
        if(x<=0 || x>n) return 0;

        return Math.max(0,2L * (x-d));

    }

    private long ring(int x,int d,int n){
        if(x<3 || d>x/2) return 0;
        if((x&1)==0 && d==x/2) return x*2L;
        return 4L*x;
    }

    private long line2ring(int line,int ring,int d){

    }


    public static void main(String[] args){
        long[] res =  new Solution().countOfPairs(3,2,1);
        for(int i =0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }

}