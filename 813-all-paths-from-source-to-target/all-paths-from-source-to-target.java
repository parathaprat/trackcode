class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(0, paths, path, graph);

        return paths;
    }

    private void dfs(int node, List<List<Integer>> paths, List<Integer> path, int[][] graph){

        if(node == graph.length - 1){
            paths.add(new ArrayList<>(path));
            return;
        }

        for(int nei : graph[node]){
            path.add(nei);
            dfs(nei, paths, path, graph);
            path.remove(path.size() - 1);
        }
    }
}