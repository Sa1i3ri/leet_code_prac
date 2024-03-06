import java.util.Scanner;

public class Solution {
    //turn: B:1 N:0，奇数靠近，偶数远离
    private String zhuaNedd(int w,int h,int x1,int y1,int x2,int y2){
        int steps = y1-y2;
        int stepN = steps/2;
        int stepB = steps-stepN;

        int x2_far;
        int x1_far;

        if((steps&1)==1){
            //可赢
            if(x1>x2){
                x2_far = Math.max(1,x2-stepN);
                x1_far = Math.max(1,x1-stepB);
                if(x1_far<=x2_far){
                    return "Beihang";
                }else{
                    return "Dongda";
                }
            }else{
                x2_far = Math.min(w,x2+stepN);
                x1_far = Math.min(w,x1+stepB);
                if(x1_far>=x2_far){
                    return "Beihang";
                }else{
                    return "Dongda";
                }
            }

        }else{
            //保输
            if(x1>x2){
                x2_far = Math.min(w,x2+stepN);
                x1_far = Math.min(w,x1+stepB);
                if(x2_far>=x1_far){
                    return "Nanda";
                }else{
                    return "Dongda";
                }
            }else{
                x2_far = Math.max(1,x2-stepN);
                x1_far = Math.max(1,x1-stepB);
                if(x2_far<=x1_far){
                    return "Nanda";
                }else{
                    return "Dongda";
                }
            }
        }


    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i =0;i<n;i++){
            System.out.println(new Solution().zhuaNedd(scanner.nextInt(),scanner.nextInt(),
                    scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
        }

        //System.out.println(new Solution().zhuaNedd(5,6,3,5,2,2));

    }

}
