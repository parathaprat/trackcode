class Solution {
    public int findKthLargest(int[] nums, int k) {

        int ans = -1;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int num : nums){
            maxHeap.offer(num);
        }

        for(int i = 0 ; i < k; i++){
            ans = maxHeap.poll();
        }

        return ans;
    }
}