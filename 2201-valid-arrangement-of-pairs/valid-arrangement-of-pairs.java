class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        //create graph to hold each node and adj list; int = node, stack = adj list
        Map<Integer, Stack<Integer>> gr = new HashMap<>();

        //create maps to hold in and out degrees fro each node
        Map<Integer, Integer> inDeg = new HashMap<>();
        Map<Integer, Integer> outDeg = new HashMap<>();

        //cycle through pairs and extract u and v coordinates
        for(int[] pair: pairs){
            int u = pair[0];
            int v = pair[1];

            //add each pair to graph -> int u and stack v
            gr.computeIfAbsent(u, k -> new Stack<>()).push(v);

            //also add to in & out maps; 0 if u not present and +1 if present
            outDeg.put(u, outDeg.getOrDefault(u, 0) + 1);
            inDeg.put(v, inDeg.getOrDefault(v, 0) + 1);
        }

        //finding starting node -> out - in == 1 || any in case of a cycle
        //stream of nodes from gr, find first node with dif of in - out == 1 OR get any random node
        int startNode = gr.keySet().stream()
            .filter(node -> outDeg.getOrDefault(node, 0) - inDeg.getOrDefault(node, 0) == 1).findFirst()
            .orElse(gr.keySet().iterator().next());

        //create ans list and call DFS func
        List<int[]> ans = new ArrayList<>();
        dfs(gr, ans, startNode);

        //reverse ans, convert to 2D array and return
        Collections.reverse(ans);

        return ans.toArray(new int[ans.size()][]);

    }

    //dfs takes in graph, ans and a node
    void dfs(Map<Integer, Stack<Integer>> gr, List<int[]> ans, int node){
        
        //find adj list(stack) for that particular node and do dfs
        Stack<Integer> stack = gr.getOrDefault(node, new Stack<>());

        //while stack is empty, get neighbor node from adj list, call dfs on it; then add to ans
        while(!stack.isEmpty()){
            int ne = stack.pop();
            dfs(gr, ans, ne);
            ans.add(new int[] {node, ne});
        }

    }
}