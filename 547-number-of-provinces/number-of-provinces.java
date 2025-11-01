class Solution {
    public int findCircleNum(int[][] isConnected) {

        //DFS

        Set<Integer> visited = new HashSet<>();
        int prov = 0;
        
        for(int i = 0; i < isConnected.length; i++){
            
            if(!visited.contains(i)){
                dfs(i, isConnected, visited);
                prov++;
            }
        }

        return prov;
        
    }

    private void dfs(int city, int[][] isConnected, Set<Integer> visited){

        visited.add(city);

        for(int i = 0; i < isConnected[city].length; i++){

            if(isConnected[city][i] == 1 && !visited.contains(i)){
                dfs(i, isConnected, visited);
            }
        }
    }
}