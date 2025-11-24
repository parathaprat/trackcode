class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);

        dfs(0, path, paths, graph);

        return paths;
        
    }

    private void dfs(int node, List<Integer> path, List<List<Integer>> paths, int[][] graph){

        if(node == graph.length - 1){
            paths.add(new ArrayList<>(path));
            return;
        }

        for(int nei : graph[node]){

            path.add(nei);
            dfs(nei, path, paths, graph);
            path.remove(path.size() - 1);
        }
    }
}