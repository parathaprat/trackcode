class Solution {
    public int countComponents(int n, int[][] edges) {

        //dfs
        Set<Integer> visited = new HashSet<>();
        int comp = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < n; i++){

            if(!visited.contains(i)){
                dfs(i, visited, map);
                comp++;
            }
        }

        return comp;
    }

    private void dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> map){

        if(visited.contains(node)) return;

        visited.add(node);

        for(int nei : map.get(node)){
            dfs(nei, visited, map);
        }

        return;
    }
}