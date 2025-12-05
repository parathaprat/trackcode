class Solution {
    public int maxSumDivThree(int[] nums) {

        int total = 0;
        float smallest_one = Integer.MAX_VALUE;
        float smallest_two = Integer.MAX_VALUE;

        for(int num : nums){
            total += num;

            if(num % 3 == 1){
                smallest_two = Math.min(smallest_two, num + smallest_one);
                smallest_one = Math.min(smallest_one, num);
            }

            if(num % 3 == 2){
                smallest_one = Math.min(smallest_one, smallest_two + num);
                smallest_two = Math.min(smallest_two, num);
            }
        }

        if(total%3 == 0) return total;
        if(total%3 == 1) return total - (int)smallest_one;
        if(total%3 == 2) return total - (int)smallest_two;

        return 0;
    }
}