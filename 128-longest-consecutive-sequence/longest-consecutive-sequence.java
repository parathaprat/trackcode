class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int ans = 0;

        for(int num : nums){
            set.add(num);
        }


        for(int num : set){

            if(!set.contains(num - 1)){

                int len = 0;
                while(set.contains(num + len)){
                    len++;
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}