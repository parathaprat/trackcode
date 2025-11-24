class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        dfs(0, graph, res, cur);

        return res;
        
    }

    private void dfs(int node, int[][] graph, List<List<Integer>> res, List<Integer> cur){

        cur.add(node);

        if(node == graph.length - 1){
            res.add(new ArrayList<>(cur));
        }


        for(int nei : graph[node]){
            dfs(nei, graph, res, cur);
        }

        cur.remove(cur.size() - 1);
        return;

    }
}