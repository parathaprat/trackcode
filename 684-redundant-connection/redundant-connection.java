class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int n = edges.length;

        for(int i = 1; i <= n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] e : edges){

            int u = e[0];
            int v = e[1];

            Set<Integer> vis = new HashSet<>();

            if(dfs(u, v, map, vis)){
                return e;
            }

            map.get(u).add(v);
            map.get(v).add(u);
        }

        return new int[0];
    }

    private boolean dfs(int cur, int target, Map<Integer, List<Integer>> map, Set<Integer> vis){

        if(vis.contains(cur)) return false;

        if(cur == target) return true;

        vis.add(cur);

        for(int nei : map.get(cur)){
            if(dfs(nei, target, map, vis)) return true;
        }

        return false;
    }
}