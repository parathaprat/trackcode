class Solution {
    public int longestConsecutive(int[] nums) {
        
        //use a set to store nums
        //track longest var
        //if -1 not in set, check if consec nums present with length
        //update and return longest

        Set<Integer> set = new HashSet<>();
        int longest = 0;

        //adding nums to set
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        //if not iterated over the entire set (iterate over nums array) we get hit with a TLE in java due to duplicates
        for(int num : set){

            if(!set.contains(num - 1)){

                int length = 0;

                while(set.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}