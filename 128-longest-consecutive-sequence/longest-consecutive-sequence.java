class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        
        int maxLen = 0;

        for(int num : set){

            if(!set.contains(num - 1)){

                int track = num;

                int longest = 1;

                while(set.contains(track + 1)){
                    track += 1;
                    longest++;
                }

                maxLen = Math.max(maxLen, longest);
            }
        }

        return maxLen;
    }
}