class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        
        int n = heights.length;
        int q = queries.length;

        int[] result = new int[q];
        Arrays.fill(result, -1);

        List<List<int[]>> deferred = new ArrayList<>();

        for(int i = 0; i < n; i++){
            deferred.add(new ArrayList<>());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < q; i++){

            int a = queries[i][0];
            int b = queries[i][1];

            //for each query, make building a < building b
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }

            //base, and if not, add height of larger and index of query to deferred
            if(a == b || heights[a] < heights[b]) result[i] = b;
            else deferred.get(b).add(new int[]{heights[a], i});
        }

        //process each buildings queries list
        for(int i = 0; i < n; i++){
            for(int[] query : deferred.get(i)) pq.add(query);

            //if building[i] has a height greater than our deferred query, assign it as result
            while(!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                result[pq.poll()[1]] = i;
            }
        }

        return result;

    }
}