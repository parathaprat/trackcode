class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }

        int maxLen = 0;

        for(int num : set){

            int curNum = num;
            int curLen = 1;

            if(!set.contains(curNum - 1)){

                while(set.contains(curNum + 1)){

                    curNum += 1;
                    curLen += 1;

                }

                maxLen = Math.max(curLen, maxLen);
            }
        }

        return maxLen;
    }
}