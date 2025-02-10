class Solution {
    public int getLargestOutlier(int[] nums) {
        
        //hashmap of nums, loop and treat each as outlier, check if rem sum/2 exists in map, num[i] is outlier

        Map<Integer, Integer> map = new HashMap<>();
        int totalSum = 0;
        int ans = Integer.MIN_VALUE;

        for(int num : nums){

            map.put(num, map.getOrDefault(num, 0) + 1);
            totalSum += num;

        }

        for(int i = 0; i < nums.length; i++){

            //totalSum - outlier
            int remSum = totalSum - nums[i];

            //remove and add selected outlier from rest of the list
            map.put(nums[i], map.get(nums[i]) - 1);

            if(remSum % 2 == 0 && map.containsKey(remSum/2)){
                
                int count = map.get(remSum/2);

                if(count > 0){
                    ans = Math.max(nums[i], ans);
                }
            }

            map.put(nums[i], map.get(nums[i]) + 1);
        }

        return ans;
    }
}