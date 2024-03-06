import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity<targetCapacity) return false;
        if(jug1Capacity==0 || jug2Capacity==0){
            return targetCapacity==jug1Capacity || targetCapacity==jug2Capacity;
        }
        return   targetCapacity % gcd(Math.min(jug1Capacity,jug2Capacity),Math.max(jug1Capacity,jug2Capacity))==0;
    }

    private int gcd(int x,int y){
        int re = y % x;
        while (re!=0){
            y=x;
            x=re;
            re = y%x;
        }
        return  x;
    }


    public static void main(String[] args){
        System.out.println(new Solution().canMeasureWater(11,3,13));
    }


}