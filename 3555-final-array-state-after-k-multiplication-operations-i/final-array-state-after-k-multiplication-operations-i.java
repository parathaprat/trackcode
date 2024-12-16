class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        

        int n = nums.length;

        while(k-- > 0){
            
            //for each k, get index and value of smallest element
            int index = 0;
            int ans = nums[0];

            for(int i = 0; i < n; i++){

                if(ans > nums[i]){
                    ans = nums[i];
                    index = i;
                }
            }

            //once smallest is found, muliply and set in nums; repeat k times
            nums[index] = nums[index] * multiplier;

        }

        return nums;
    }
}