import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    public String longestWord(String[] words) {
        int n = words.length;
        String res = "";
        HashSet<String> hashSet = new HashSet<>();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length()) return o1.length()-o2.length();
                return o2.compareTo(o1);
            }
        });

        hashSet.add("");

        for(int i =0;i<n;i++){
            if(hashSet.contains(words[i].substring(0,words[i].length()-1))){
                hashSet.add(words[i]);
                if(words[i].length()>=res.length()){
                    res = words[i];
                }
            }

        }
        return res;
    }

    private String dfs(String[] words,String start){
        if(!isIn(words,start)) return "";
        String res = new String(start);
        for(char i = 'a';i<='z';i++){
            String cur = dfs(words,start+i);
            if(cur.length() > res.length()){
                res = cur;
            }

        }
        return res.toString();
    }

    private boolean isIn(String[] words,String word){
        int n = words.length;
        for(int i =0;i<n;i++){
            if(word.equals(words[i])){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args){
        System.out.println(new Solution().longestWord(new String[]{"rac","rs","ra","on","r","otif",
                "o","onpdu","rsf","rs","ot","oti","racy","onpd"}));
    }


}