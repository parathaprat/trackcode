class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //bucket sort
        //maxHeap, custom comp

        //create a freq map
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : map.keySet()){

            int freq = map.get(num);

            if(buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(num);
        }

        int[] ans = new int[k];

        int index = 0;

        for(int i = buckets.length - 1; i >= 0; i--){

            if(buckets[i] != null){
                
                for(int num : buckets[i]){
                    ans[index] = num;
                    index++;
                    if(index == k) return ans;
                }
            }
        }

        return ans;
    }
}