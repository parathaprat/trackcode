class Solution {
    public int majorityElement(int[] nums) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        //Moore's Voting Algorithm

        int count = 0;
        int candidate = 0;

        for(int num : nums){

            if(count == 0){
                candidate = num;
            }
            if(num == candidate){
                count++;
            }
            else{
                count--;
            }
        }

        return candidate;
        
    }
}