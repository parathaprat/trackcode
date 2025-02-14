class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //HashMap for freq
        //Array of Lists for bucks

        //bucket sort -> each index reps count, and each count holds a list of elements with that count

        //freq map
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        //buckets -> Array of Lists
        List<Integer>[] bucks = new ArrayList[nums.length + 1];

        //initialise each buck
        for(int i = 0; i <= nums.length; i++){

            bucks[i] = new ArrayList<>();
        }

        //populating bucks using map
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int num = entry.getKey();
            int freq = entry.getValue();

            bucks[freq].add(num);
        }

        //populating ans but looking at elements with highest freqs

        int index = 0;

        int[] ans = new int[k];

        for(int i = bucks.length - 1; i >= 0; i--){

            for(int num : bucks[i]){
                ans[index] = num;
                index++;

                if(index == k) return ans;
            }
        }

        return ans;
    }
}