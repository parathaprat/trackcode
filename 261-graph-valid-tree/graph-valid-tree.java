class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1) return false;
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] e : edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();

        if(!dfs(0, -1, map, visited)) return false;

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> map, Set<Integer> visited){

        if(visited.contains(node)) return false;

        visited.add(node);

        for(int nei : map.get(node)){
            if(nei == parent) continue;

            if(!dfs(nei, node, map, visited)) return false;
        }

        return true;
    }
}