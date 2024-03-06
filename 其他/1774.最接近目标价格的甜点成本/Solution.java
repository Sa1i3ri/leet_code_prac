import java.util.Arrays;

class Solution {
    int min = 0;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

        this.min = Arrays.stream(baseCosts).min().getAsInt();
        for(int i =0;i<baseCosts.length;i++){
            dfs(toppingCosts,0,target,baseCosts[i]);
        }
        return min;
    }

    private void dfs( int[] toppingCosts, int index,int target,int curCost){
        if(Math.abs(curCost-target) < Math.abs(min-target)){
            min = curCost;
        }else if(Math.abs(curCost-target) == Math.abs(min-target)){
            min = Math.min(min,curCost);
        }
        if(curCost>target || index>=toppingCosts.length) return;
        dfs(toppingCosts,index+1,target,curCost);
        dfs(toppingCosts,index+1,target,curCost+toppingCosts[index]);
        dfs(toppingCosts,index+1,target,curCost+2*toppingCosts[index]);
    }

    public static void main(String[] args){
        int[] baseCosts = new int[]{3,10};
        int[] toppingCosts = new int[]{2,5};
        int target = 9;
        System.out.println(new Solution().closestCost(baseCosts,toppingCosts,target));
    }
}