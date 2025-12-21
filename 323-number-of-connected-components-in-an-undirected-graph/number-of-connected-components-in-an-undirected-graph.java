class Solution {
    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] e : edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        Set<Integer> vis = new HashSet<>();
        int count = 0;

        for(int i = 0; i < n; i++){

            if(!vis.contains(i)){
                dfs(i, map, vis);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> vis){

        if(vis.contains(node)) return;

        vis.add(node);

        for(int nei : map.get(node)){
            dfs(nei, map, vis);
        }
    }
}