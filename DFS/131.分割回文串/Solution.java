import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),s,0);
        return res;

    }


    private void dfs(List<List<String>> res,List<String> path,String s, int index){
        if(index >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i =index+1;i<=s.length();i++){
            String t = s.substring(index,i);
            if(isPart(t)){
                path.add(t);
                dfs(res,path,s,i);
                path.remove(path.size()-1);
            }

        }
    }

    private boolean isPart(String s){
        int n = s.length();
        int left = 0;
        int right = n-1;
        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args){
        new Solution().partition("aab");
    }
}