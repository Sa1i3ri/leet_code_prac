import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int s_i = 0;

        for(int i =0;i<g.length;i++){
            while (s_i<s.length && s[s_i] < g[i]){
                s_i++;
            }
            if(s_i>s.length-1) break;
            s_i++;
            res++;

        }

        return res;

    }
}