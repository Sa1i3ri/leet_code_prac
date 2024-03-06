import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

class Solution {
    private List<Integer>[] list;
    private HashSet<Long> guess;
    private int k,res,num0;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.list = new List[edges.length+1];
        this.guess = new HashSet<>();
        for(int i =0;i<list.length;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] curEdge:edges){
            int x = curEdge[0];
            int y = curEdge[1];
            list[x].add(y);
            list[y].add(x);
        }
        for(int[] guessEdge : guesses){
            int x = guessEdge[0];
            int y = guessEdge[1];
            guess.add((long)x<<32 | y );
        }

        this.k = k;

        dfs(0,-1);
        reRoot(0,-1,num0);
        return res;

    }

    private void dfs(int x,int pa){
        for(int son:list[x]){
            if(son!=pa){
                if(guess.contains((long) x<<32 | son)) num0++;
                dfs(son,x);
            }
        }
    }

    private void reRoot(int x,int pa,int curNum){
        if(curNum>=k) res++;
        for(int son:list[x]){
            if(son!=pa){
                //下一代的num
                int nextNum = curNum;
                if(guess.contains((long) x<<32 | son)) nextNum--;//从父亲到儿子，原来对，之后错
                if(guess.contains((long) son<<32 | x)) nextNum++;
                reRoot(son,x,nextNum);
            }
        }
    }


}