class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        //Priority Queue that sorts the points in ascending order from distance from origin
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> getDist(a) - getDist(b));

        for(int[] ptSet : points){
            minHeap.add(ptSet);
        }

        int[][] ans = new int[k][2];

        for(int i = 0; i < k; i++){
            ans[i] = minHeap.poll();
        }

        return ans;


    }

    private int getDist(int[] pt){

        return pt[0] * pt[0] + pt[1] * pt[1];
    }


}