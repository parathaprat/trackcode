class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        
        //create and initialize adj list from given edges 
        List<Integer>[] adjList = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        //poplate adjList
        for(int[] edge : edges){

            int node1 = edge[0];
            int node2 = edge[1];

            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        //java uses pass-by-value, using a single array so it retains value
        int[] componentCount = new int[1];

        //helper function
        dfs(0, -1, adjList, values, k, componentCount);

        return componentCount[0];
    }

    //main logic
    long dfs(int currentNode, int parentNode, List<Integer>[] adjList, int[] values, int k, int[] componentCount){

        long sum = 0;

        //calculating subtree sums
        for(int neighborNode : adjList[currentNode]){

            if(neighborNode != parentNode){

                sum += dfs(neighborNode, currentNode, adjList, values, k, componentCount);
            }
        }

        //checking if subtree can form a CC
        sum+= values[currentNode];

        if(sum % k == 0){
            componentCount[0]++;
            sum = 0;
        }

        //returning sum to helper, which CC gets updated to final ans
        return sum;
    }
}