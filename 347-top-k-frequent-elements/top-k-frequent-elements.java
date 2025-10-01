class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //freq map
        //Bucket sort -> freq is index, and index holds value
        //loop from the back

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buck = new ArrayList[nums.length + 1];

        for(int i = 0; i <= nums.length; i++){
            buck[i] = new ArrayList<>();
        }

        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            buck[val].add(key);
        }

        int[] ans = new int[k];

        int count = 0;
        for(int i = buck.length - 1; i >= 0; i--){

            for(int num : buck[i]){
                ans[count++] = num;
                if(count == k) break;
            }

            if(count == k) break;
        }

        return ans;
    }
}