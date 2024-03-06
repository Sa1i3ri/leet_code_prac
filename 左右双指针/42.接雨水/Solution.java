class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length-1;
        int l_max = 0;
        int r_max = 0;

        while (l<r){
            l_max = Math.max(l_max,height[l]);
            r_max = Math.max(r_max,height[r]);
            if(l_max<r_max){
                res += l_max-height[l];
                l++;
            } else{
                res += r_max-height[r];
                r--;
            }

        }


        return res;


    }

    public static void main(String[] args){
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}