class Solution {
    public int maxSumDivThree(int[] nums) {

        //if(totalSum % 3 == 0) return totalSum
        //if(totalSum % 3 == 1) return totalSum - smallest_one
        //if(totalSum % 3 == 2) return totalSum - smallest_two

        int totalSum = 0;
        float smallest_one = Integer.MAX_VALUE;
        float smallest_two = Integer.MAX_VALUE;

        for(int num : nums){

            totalSum += num;

            if(num % 3 == 1){
                smallest_two = Math.min(smallest_two, smallest_one + num);
                smallest_one = Math.min(smallest_one, num);
            }
            else if(num % 3 == 2){
                smallest_one = Math.min(smallest_one, num + smallest_two);
                smallest_two = Math.min(smallest_two, num);
            }
        }

        if(totalSum % 3 == 0) return totalSum;
        if(totalSum % 3 == 1) return totalSum - (int)smallest_one;
        if(totalSum % 3 == 2) return totalSum - (int)smallest_two;

        return 0;
    }
}