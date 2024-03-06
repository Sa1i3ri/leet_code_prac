import java.util.*;
import java.util.concurrent.TimeoutException;

public class Solution {

    private String succeed(HashMap<Character,List<Character>> hashMap,Character toTest,StringBuilder path){
        List<Character> list = hashMap.get(toTest);
        for (char cur : list) {
            if(path.toString().contains(cur+"")){
                continue;
            }
            path.append(cur);

            succeed(hashMap,cur,path);

        }
        return path.toString();
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char toTest = scanner.next().charAt(0);
        HashMap<Character,List<Character>> hashMap = new HashMap<>();

        for(int i =0;i<n;i++){
            List<Character> cur = new ArrayList<>();
            Character put = scanner.next().charAt(0);
            int num = scanner.nextInt();
            for(int j =0;j<num;j++){
                cur.add(scanner.next().charAt(0));
            }
            hashMap.put(put,cur);
        }
        System.out.println(new Solution().succeed(hashMap,toTest,new StringBuilder(String.valueOf(toTest))));


//        HashMap<Character,List<Character>> test = new HashMap<>();
//        test.put('A', Arrays.asList());
//        test.put('B', Arrays.asList('A'));
//        test.put('C', Arrays.asList('A','B','D'));
//        test.put('D', Arrays.asList('A','E'));
//        test.put('E', Arrays.asList());
//        test.put('F', Arrays.asList('C'));
//
//
//        System.out.println(new Solution().succeed(test,'C',new StringBuilder("C")));

    }

}
