class Solution {
    public int getLargestOutlier(int[] nums) {
        
        //freq map
        Map<Integer, Integer> freq = new HashMap<>();

        //totalSum
        int totalSum = 0;

        //calculating totalSum and populating freq map
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        //final ans
        int maxAns = Integer.MIN_VALUE; 

        //every num becomes outlier
        //reduce freq in map, reduce from totalSum
        //if rest of the sum % 2 == 0; nums[i] is an outlier
        //math.max with final ans
        for(int num : nums){
            
            int twoSum = totalSum - num;

            freq.put(num, freq.get(num) - 1);

            if(twoSum % 2 == 0){

                int count = freq.getOrDefault(twoSum/2, 0);
                if(count > 0) maxAns = Math.max(num, maxAns);
                
            }

            freq.put(num, freq.get(num) + 1);
            
        }

        return maxAns;
    }
}