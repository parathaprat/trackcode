class Solution {
    public int singleNumber(int[] nums) {
        
        //XOR the entire thing buy itslef
        //y XOR y = 0;
        //y XOR 0 = y;
        //double numbers cancel each other out, leavin gbehind hte only single number

        int result = 0;

        for(int num : nums){

            result = result ^ num;
        }

        return result;
    }
}