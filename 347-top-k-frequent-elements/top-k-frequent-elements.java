class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //Approach: Create frequency map using HashMap
        //Use bucket sort to group frequencies
        //get from the back

        HashMap<Integer, Integer> map = new HashMap<>();

        //populate freq map
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //Array of lists for buckets
        List<Integer>[] buck = new ArrayList[nums.length + 1];

        //initialize
        for(int i = 0; i <= nums.length; i++){
            buck[i] = new ArrayList<>();
        }

        //populate bucks
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){

            int key = entry.getKey();
            int freq = entry.getValue();

            buck[freq].add(key);
        }

        int[] ans = new int[k];

        //go through bucks from the back 
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