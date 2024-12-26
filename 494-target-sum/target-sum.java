class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        //creating hashmap to store (sum, count)
        Map<Integer, Integer> dp = new HashMap<>();

        //base case -> sum = 0, only 1 way (exclude all elements)
        dp.put(0, 1);

        for(int num : nums){
            //temporary map to store next iteration of dp -> necessary to avoid overwrite
            Map<Integer, Integer> nextDp = new HashMap<>();

            //for each sum in the dp array, add and sub next element and add to temp nextDp array
            for(int sum : dp.keySet()){

                int count = dp.get(sum);

                //adding next element
                nextDp.put(sum + num, nextDp.getOrDefault(sum + num, 0) + count);

                //subtracting next element
                nextDp.put(sum - num, nextDp.getOrDefault(sum - num, 0) + count);
            }

            //assign changes from iteration to main dp array
            dp = nextDp;
        }

        //return value for target if exists
        return dp.getOrDefault(target, 0);
    }
}