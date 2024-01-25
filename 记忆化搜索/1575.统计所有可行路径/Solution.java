import java.util.Arrays;

class Solution {
    public int countRoutes1(int[] locations, int start, int finish, int fuel) {
        int mod = 1000000007;


        int[][] cache = new int[locations.length][fuel+1];
        for(int i =0;i<cache.length;i++){
            Arrays.fill(cache[i],-1);
        }

        return dfs(locations,start,finish,fuel,cache,mod)%mod;
    }
    
    private int dfs(int[] location,int curPos,int finish,int fuel,int[][] cache,int mod){
        if(fuel<0) return 0;
        if(cache[curPos][fuel]!=-1) return cache[curPos][fuel];
        cache[curPos][fuel] = 0;
        if(fuel < Math.abs(location[curPos] - location[finish])){
            return 0;
        }
        if(curPos == finish){
            cache[curPos][fuel]+=1;
        }


        for(int i =0;i<location.length;i++){
            if(i == curPos) continue;
            cache[curPos][fuel] += dfs(location,i,finish,fuel-Math.abs(location[i] - location[curPos]),cache,mod);
            cache[curPos][fuel] %= mod;
        }
        return cache[curPos][fuel];

    }

    public int countRoutes2(int[] locations, int start, int finish, int fuel) {
        int mod = 1000000007;


        int[][] cache = new int[locations.length][fuel+1];
        for(int j = 0;j<=fuel;j++){
            cache[finish][j] = 1;
        }

        for(int curFuel =0;curFuel<cache[0].length;curFuel++){
            for(int i  =0;i<locations.length;i++){
                for(int k =0;k<locations.length;k++){
                    if(i==k) continue;
                    int need = Math.abs(locations[i] - locations[k]);
                    if(curFuel>=need){
                        cache[i][curFuel] += cache[k][curFuel- need];
                        cache[i][curFuel] %= mod;
                    }

                }
            }
        }

        return cache[start][fuel];
    }


    public static void main(String[] args){
        int[] location = new int[]{46,75,85,43,62,92,22,89,107,73,98,93,36,32,81,101,71,109,11,56,13,54,86,80,44,66,14,9,23,84,91,16,17,33,64,7,60};
        int start = 22;
        int finish = 4;
        int fuel = 50;

        System.out.println(new Solution().countRoutes2(location,start,finish,fuel));

    }



}