class Solution {
    public int missingNumber(int[] nums) {

        //find sum of all nos in range 0, no
        //find actual sum
        //subtract and return

        int sum = 0;

        for(int i = 0; i <= nums.length; i++){
            sum += i;
        }

        for(int num : nums){
            sum -= num;
        }

        return sum;


        
    }
}