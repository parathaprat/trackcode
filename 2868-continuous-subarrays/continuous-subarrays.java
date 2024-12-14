class Solution {
    public long continuousSubarrays(int[] nums) {
        
        //storing key value pairs in sorted order using treemap
        TreeMap<Integer, Integer> freq = new TreeMap<>();

        long count = 0;

        //using sliding window approach
        int left = 0;
        int right = 0;
        int n = nums.length;

        while(right < n && left <= right){
            
            //add each element at right pointer to map, increase freq if already exists
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            //while diff between largest and smallest elements in the window is > 2, remove those elments OR reduce frequency
            while(freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2){
                freq.put(nums[left], freq.get(nums[left]) - 1);

                if(freq.get(nums[left]) == 0){
                    freq.remove(nums[left]);
                }

                //move left pointer//reduce window if not satisfying condition
                left++;
            }

            //this way of calculating count accounts for all valid subarrays given diff(biggest - smallest) < 2
            count += right - left + 1;
            right++;
        }

        return count;
    }
}