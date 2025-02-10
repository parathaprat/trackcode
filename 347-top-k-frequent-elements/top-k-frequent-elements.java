class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        for(int i = 0; i < k; i++){

            ans[i] = maxHeap.poll();

        }

        return ans;

        
    }
}