class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        //main logic -> MHT can be at max 2 nodes

        //adj list
        //queue
        //edgeCount

        if(n == 1) return List.of(0);

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){

            adj.add(new ArrayList<>());

        }

        for(int[] edge : edges){

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }

        Queue<Integer> leaf = new LinkedList<>();

        //create a edgecount map, add edgecount == 1; add to leaf q
        Map<Integer, Integer> map = new HashMap<>();

        //for each node, size of its adj list is the size 
        for(int i = 0; i < n; i++){

            map.put(i, adj.get(i).size());

            //if edge count == 1 fro any node, add it to leaf q
            if(map.get(i) == 1) leaf.add(i);
        }

        while(!leaf.isEmpty()){

            if(n <= 2) break;

            int size = leaf.size();

            for(int i = 0; i < size; i++){

                int leafz = leaf.poll();
                n -= 1;

                //reduce edge count for each of its neighbors
                for(int nei : adj.get(leafz)){

                    map.put(nei, map.get(nei) - 1);
                    if(map.get(nei) == 1) leaf.add(nei);

                }

            }
        }

        return new ArrayList<>(leaf);




    }
}