class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int max_seq_len = 0;


        for(int num : set){

            int curr_seq_len = 1;
            int curr_num = num;

            if(!set.contains(curr_num - 1)){

                while(set.contains(curr_num + 1)){
                    curr_num++;
                    curr_seq_len++;
                }
            }

            max_seq_len = Math.max(max_seq_len, curr_seq_len);
        }

        return max_seq_len;
    }
}