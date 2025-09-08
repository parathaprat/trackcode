class Solution {
    public int[][] kClosest(int[][] points, int k) {

        //minHeap, custom comparator, add all, poll k and return 
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(getDist(a), getDist(b)));

        int[][] ans = new int[k][2];

        for(int[] point : points){
            minHeap.offer(point);
        }

        for(int i = 0; i < k; i++){
            ans[i] = minHeap.poll();
        }

        return ans;
    }

    private int getDist(int[] pt){
        return pt[0] * pt[0] + pt[1] * pt[1];
    }
}