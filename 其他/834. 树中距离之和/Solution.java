import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private int n;
    private ArrayList<Integer>[] list;
    private int[] size,res;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.list = new ArrayList[n];
        for(int i =0;i<list.length;i++){
            list[i] = new ArrayList<>();
        }
        this.size = new int[n];
        this.res = new int[n];
        this.n = n;
        for (int[] curEdge : edges) {
            int x = curEdge[0];
            int y = curEdge[1];
            list[x].add(y);
            list[y].add(x);
        }

        dfs(0,-1,0);
        reRoot(0,-1);
        return res;
    }

    private void dfs(int x,int pa,int depth){
        res[0] += depth;
        size[x]=1;
        for(int son:list[x]){
            if(son!=pa){
                dfs(son,x,depth+1);
                size[x] += size[son];
            }
        }
    }

    private void reRoot(int x,int pa){
        for(int son:list[x]){
            if(son!=pa){
                res[son] = res[x] + n - 2*size[son];
                reRoot(son,x);
            }
        }
    }

    public static void main(String[] args){
        int[] res = new Solution().sumOfDistancesInTree(4,new int[][]{
                new int[]{1,2},new int[]{3,2},new int[]{3,0}
        });

        for(int x: res){
            System.out.print(x+" ");
        }

    }


}