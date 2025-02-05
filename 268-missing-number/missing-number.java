class Solution {
    public int missingNumber(int[] nums) {
        
        //only one number is missing [0, n]
        //calculate theoretical sol if all no were present in range
        //calculate actual sum, subtract from pred and return

        int sumPred = 0;
        int sum = 0;

        for(int i = 0 ; i <= nums.length; i++){
            sumPred += i;
        }

        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
        }

        return sumPred - sum;
    }
}