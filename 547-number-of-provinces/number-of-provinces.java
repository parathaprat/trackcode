class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        //find connected components from undirected graph
        //given adj matrix
        //perform dfs, maintian visited, return number of trav

        int provinces = 0;
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < isConnected.length; i++){
            
            if(!visited.contains(i)){
                dfs(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
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