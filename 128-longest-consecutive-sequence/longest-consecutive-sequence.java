class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for(int num : nums){

            set.add(num);
        }

        int maxLen = 0;

        for(int num : set){

            int cur = num;
            int curLen = 1;

            if(!set.contains(cur - 1)){

                while(set.contains(cur + 1)){
                    cur += 1;
                    curLen++;
                }

                maxLen = Math.max(maxLen, curLen);
            }

        }

        return maxLen;
    }
}