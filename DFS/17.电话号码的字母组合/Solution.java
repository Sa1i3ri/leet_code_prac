import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        List<String>res = new ArrayList<>();
        if(digits.isEmpty()) return res;

        dfs(res,new StringBuilder(),digits,map);

        return res;

    }

    private void dfs(List<String>res, StringBuilder path,String digits,HashMap<Character,char[]> map){
        if(digits.isEmpty()){
            res.add(path.toString());
            return;
        }

        char curNum = digits.charAt(0);
        char[] fuc = map.get(curNum);

        for(int i =0;i<fuc.length;i++){
            path.append(fuc[i]);

            dfs(res,path,digits.substring(1),map);

            path.deleteCharAt(path.length()-1);

        }
    }

    public static void main(String[] args){
        List<String> res = new Solution().letterCombinations("23");
        for(int i =0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }


}