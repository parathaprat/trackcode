class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //Create a frequency map
        //Bucket sort the map -> each frequency is represented by an index, each index has values with that frequency
        //iterate from the back and return top k elements

        HashMap<Integer, Integer> map = new HashMap<>();

        //populating frequency map
        for(int i = 0; i < nums.length; i++){

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        //Create Array of Lists for buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        //Initialize each bucket
        for(int i = 0; i <= nums.length; i++){
            buckets[i] = new ArrayList<>();
        }

        //populating buckets
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();

            buckets[freq].add(key);
        }

        //going from the back through buckets

        int[] ans = new int[k];

        int count = 0;

        for(int i = buckets.length - 1; i >= 0; i--){

            for(int num : buckets[i]){
                ans[count++] = num;
                if(count == k) break;
            }

            if(count == k) break;
        }
        
        return ans;
    }
}