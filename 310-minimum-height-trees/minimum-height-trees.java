class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        //Main logic -> Nodes with minimum height can be 2 at most

        //Work backwards -> disconnect leaf nodes, add new leaf nodes to q, disconnec those ...
        //until n <= 2; return those roots

        //step1 -> convert our edges into a adj list

        if(n == 1) return List.of(0);
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){

            adj.add(new ArrayList<>());
        }

        //adj list populated
        for(int[] edge : edges){

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        } 

        //build a number of edges map
        //add edges == 1 to a q (leaf nodes)  
        Map<Integer, Integer> edgeCount = new HashMap<>();
        Queue<Integer> leaf = new LinkedList<>();

        //edgeCount populated
        for(int i = 0; i < n; i++){

            edgeCount.put(i, adj.get(i).size());
            if(edgeCount.get(i) == 1) leaf.add(i); 
        }


        //update edge count after popping from q
        //add edges w edgeCount == 1 to q again

        while(!leaf.isEmpty()){

            //if total nodes remaining <= 2; return the nodes in our q
            if(n  <= 2) break;

            int size = leaf.size();

            for(int i = 0; i < size; i++){
                //get top leaf, reduce edge count for each of its nei
                int pop = leaf.poll();
                n -= 1;

                for(int nei : adj.get(pop)){

                    edgeCount.put(nei, edgeCount.get(nei) - 1);
                    if(edgeCount.get(nei) == 1) leaf.add(nei);
                }
            }
        }

        return new ArrayList<>(leaf);

    }
}