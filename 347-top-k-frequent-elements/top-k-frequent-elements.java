class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : map.keySet()){
            maxHeap.add(num);
        }

        int[] ans = new int[k];
        int index = 0;

        while(index < k){
            ans[index] = maxHeap.poll();
            index++;
        }

        return ans;
    }
}