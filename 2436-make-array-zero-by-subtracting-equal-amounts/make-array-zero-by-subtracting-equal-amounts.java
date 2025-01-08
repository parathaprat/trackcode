class Solution {
    public int minimumOperations(int[] nums) {
        
        //return every non identical element over 0
        Set<Integer> unique = new HashSet<>();

        for(int num : nums){

            if(num > 0){
                unique.add(num);
            }
        }

        return unique.size();

    }
}