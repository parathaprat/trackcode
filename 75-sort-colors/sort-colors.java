class Solution {
    public void sortColors(int[] nums) {

        int[] count = new int[3];

        for(int num : nums){
            count[num]++;
        }

        int p = 0;

        for(int i = 0; i < count.length; i++){

            int k = count[i];

            while(k > 0){
                nums[p] = i;
                k--;
                p++;
            }
        }
    }
}