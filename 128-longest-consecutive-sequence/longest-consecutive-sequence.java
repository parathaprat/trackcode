class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int result = 0;

        for(int num : set){

            int ans = 1;

            if(!set.contains(num - 1)){

                int cur = num;

                while(set.contains(cur + 1)){
                    ans++;
                    cur++;
                }

                result = Math.max(result, ans);
            }
        }

        return result;
    }
}