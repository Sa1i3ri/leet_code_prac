class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int pro = 0;
        for(int i =0;i<prices.length;i++){
            cost = Math.min(cost,prices[i]);
            pro = Math.max(pro,prices[i]-cost);
        }
        return pro;
    }
}