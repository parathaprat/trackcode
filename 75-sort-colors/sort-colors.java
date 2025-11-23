class Solution {
    public void sortColors(int[] nums) {

        //element - freq
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int pt = 0;

        for(Map.Entry<Integer, Integer> e : freq.entrySet()){

            int iterations = e.getValue();

            while(iterations > 0){
                nums[pt] = e.getKey();
                pt++;
                iterations--;
            }
        } 
    }
}