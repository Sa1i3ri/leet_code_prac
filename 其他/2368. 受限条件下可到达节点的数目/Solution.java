import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    private ArrayList<Integer>[] list;
    private HashSet<Integer> restricted;
    private int res;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        this.list = new ArrayList[n];
        for(int i =0;i<list.length;i++){
            list[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            list[x].add(y);
            list[y].add(x);
        }
        this.restricted = new HashSet<>();
        for(int point:restricted){
            this.restricted.add(point);
        }
        dfs(0,-1);
        return res;
    }


    private void dfs(int n,int pa){
        if(!restricted.contains(n)) {
            res++;
        }else{
            return;
        }

        for(int son:list[n]){
            if(son!=pa){
                dfs(son,n);
            }
        }

    }


}