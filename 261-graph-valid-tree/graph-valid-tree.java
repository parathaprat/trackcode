class Solution {
    public boolean validTree(int n, int[][] edges) {

        //a valid tree with n nodes has n - 1 edges
        if(edges.length != n - 1) return false;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if(!dfs(0, -1, map, visit)) return false;
         
        return visit.size() == n;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> map, Set<Integer> visit){

        if(visit.contains(node)) return false;

        visit.add(node);

        for(int nei : map.get(node)){
            if(nei == parent) continue;
            if(!dfs(nei, node, map, visit)) return false;
        }

        return true;
    }
}