class Solution {
    public int findKthLargest(int[] nums, int k) {

        //minheap of k elements

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){

            pq.add(num);
            if(pq.size() > k) pq.poll();
            
        }

        return pq.poll();
        
    }
}