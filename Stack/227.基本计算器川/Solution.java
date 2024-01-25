import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        HashMap<Character,Integer> pri = new HashMap<>();
        pri.put('+',0);
        pri.put('-',0);
        pri.put('*',1);
        pri.put('/',1);

        Stack<Integer> num = new Stack<>();
        Stack<Character> symbol = new Stack<>();

        boolean lastNum = false;

        for(int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur >='0' && cur<='9'){
                int curNum = (cur - '0');
                if(lastNum){
                    curNum +=num.pop() * 10;
                }
                num.push(curNum);
                lastNum = true;
            } else if (cur == '+' || cur=='-'||cur=='*'||cur=='/') {
                while (!symbol.isEmpty() && pri.get(symbol.peek())  >= pri.get(cur)){
                    //可以先运算
                    int num1 = num.pop();
                    int num2 = num.pop();
                    char operate = symbol.pop();
                    num.push(operate(operate,num2,num1));
                }
                symbol.push(cur);
                lastNum = false;
            }
        }


        while (!symbol.isEmpty()){
            int num1 = num.pop();
            int num2 = num.pop();
            char operate = symbol.pop();
            num.push(operate(operate,num2,num1));
        }

        return num.pop();
    }

    private int operate(char operate,int x,int y){
        switch (operate){
            case '+' :return x+y;
            case '-' :return x-y;
            case '*' :return x*y;
            case '/' :return x/y;
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(new Solution().calculate("1*2-3/4+5*6-7*8+9/10"));
    }

}