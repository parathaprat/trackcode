
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int[] prefixCount = new int[nums.length + 1];
        prefixCount[0] = 1;

        int oddCountSoFar = 0;
        int result = 0;

        for(int num : nums){

            if(num % 2 == 1) oddCountSoFar++;

            if(oddCountSoFar - k >= 0){
                result += prefixCount[oddCountSoFar - k];
            }

            prefixCount[oddCountSoFar]++;
        }        

        return result;
    }
}