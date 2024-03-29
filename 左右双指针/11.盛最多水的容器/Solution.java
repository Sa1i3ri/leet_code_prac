class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length-1;

        while (l<r){
            int h = Math.min(height[l],height[r]);
            int w = r-l;

            res = Math.max(res,h*w);

            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;

    }
}