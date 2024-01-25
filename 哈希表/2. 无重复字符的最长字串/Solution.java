import java.util.HashMap;
import java.util.Map;

public class Solution {

    //保证i+1 - j之间没有重复字符
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int result = 0, i=-1,j=0;
        for(;j<s.length();j++){
            if(hashMap.containsKey(s.charAt(j))){
                i = Math.max(hashMap.get(s.charAt(j)),i) ;
            }
            hashMap.put(s.charAt(j),j);
            result = Math.max(result, j - i);
        }


        return result;
    }

    public static void main(String args[]){
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }
}
