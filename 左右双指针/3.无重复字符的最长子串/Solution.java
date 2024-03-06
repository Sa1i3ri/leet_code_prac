import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for(int right = 0;right<s.length();right++){
            while (hashSet.contains(s.charAt(right))){
                hashSet.remove(s.charAt(left));
                left++;
            }
            hashSet.add(s.charAt(right));
            res = Math.max(res,right-left+1);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}