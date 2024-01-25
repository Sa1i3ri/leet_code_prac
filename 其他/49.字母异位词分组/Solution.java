import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mainTable = new HashMap<>();

        for(String curString : strs){
            char[] curChars = curString.toCharArray();
            Arrays.sort(curChars);
            String sortedString = String.valueOf(curChars);
            List<String> list = mainTable.getOrDefault(sortedString,new ArrayList<>());
            list.add(curString);
            mainTable.put(sortedString,list);
        }

        return new ArrayList<>(mainTable.values());


    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List<List<String>> res = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(int i =0;i<res.size();i++){
            for(int j =0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j) + ' ');
            }
            System.out.println();
        }
    }
}