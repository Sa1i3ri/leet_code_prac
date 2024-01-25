import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int minimumPushes(String word) {
        int res = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i =0;i<word.length();i++){
            int count = hashMap.getOrDefault(word.charAt(i),0);
            hashMap.put(word.charAt(i),count+1);
        }

        for(int i =0;i<8 && !hashMap.isEmpty();i++){
            char key = getMax(hashMap);
            res +=  hashMap.get(key);
            hashMap.remove(key);
        }

        for(int i =0;i<8&& !hashMap.isEmpty();i++){
            char key = getMax(hashMap);
            res +=  (hashMap.get(key)*2);
            hashMap.remove(key);
        }
        for(int i =0;i<8&& !hashMap.isEmpty();i++){
            char key = getMax(hashMap);
            res +=  (hashMap.get(key)*3);
            hashMap.remove(key);
        }
        for(int i =0;i<8&& !hashMap.isEmpty();i++){
            char key = getMax(hashMap);
            res +=  (hashMap.get(key)*4);
            hashMap.remove(key);
        }

        return res;



    }

    private char getMax(HashMap<Character,Integer> hashMap){
        int max = -1;
        char key = 0;

        for(char temp: hashMap.keySet()){
            if(max < hashMap.get(temp)){
                key = temp;
                max = hashMap.get(temp);
            }
        }
        return key;
    }

    public static void main(String[] args){
        System.out.println(new Solution().minimumPushes("xycdefghij"));
    }
}