
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for(int i =0;i<numRows;i++){
            //遍历行
            int cur = i;
            int sentinel = numRows-1;

            while (cur<n){
                res.append(s.charAt(cur));
                int other = 2*sentinel-cur;
                if(other < n && other!=cur+2*numRows-2 && cur!=sentinel){
                    res.append(s.charAt(other));
                }
                cur += 2*numRows-2;
                sentinel += 2*numRows-2;
            }
        }
        return res.toString();

    }

    public static void main(String[] args){
        System.out.println(new Solution().convert("A",1));
    }
}