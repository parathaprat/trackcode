class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> vis = new HashSet<>();

    public int countComponents(int n, int[][] edges) {

        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] e : edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        int count = 0;

        for(int i = 0; i < n; i++){

            if(!vis.contains(i)){
                dfs(i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node){

        if(vis.contains(node)) return;
        vis.add(node);

        for(int nei : map.get(node)){
            dfs(nei);
        }
    }
}