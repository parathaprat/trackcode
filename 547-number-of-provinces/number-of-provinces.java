class Solution {
    public int findCircleNum(int[][] isConnected) {

        Set<Integer> set = new HashSet<>();

        int prov = 0;

        for(int i = 0; i < isConnected.length; i++){

            if(!set.contains(i)){
                dfs(i, isConnected, set);
                prov++;
            }
        }

        return prov;
    }

    private void dfs(int city, int[][] isConnected, Set<Integer> set){

        if(set.contains(city)) return;

        set.add(city);

        for(int i = 0; i < isConnected[city].length; i++){
            
            if(isConnected[city][i] == 1 && !set.contains(i)){

                dfs(i, isConnected, set);
            }
        }

        return;
    }
}