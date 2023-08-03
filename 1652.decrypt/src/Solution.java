class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] copy = new int[len];
        if(k==0){
            return k_0(code);
        }else if(k>0){
            for(int i  = 0 ;i<len;i++){//for each ele
                for(int j = 1;j<=k;j++){
                    copy[i] += find_k_over_0(code,i,j);
                }
            }
            return copy;
        }else{
            for(int i = 0;i<len;i++){
                for(int j = -1;j>=k;j--){
                    copy[i] += find_k_below_0(code,i,j);
                }
            }
            return copy;
        }
    }

    private int[] k_0(int[] code){
        int len = code.length;
        int[] copy = code;
        for(int i = 0;i<len;i++){
            copy[i] = 0;
        }
        return copy;
    }
    private static int find_k_over_0(int[] code,int index,int k){
        int len = code.length;
        return code[(index + k) % len];
    }

    private static int find_k_below_0(int[] code,int index,int k){
        if(index+k >=0){
            return code[index+k];
        }else{
            return find_k_below_0(code,index+code.length,k);
        }
    }





}