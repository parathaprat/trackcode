class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        List<Integer> index = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            //if index out of window, remove
            while(!index.isEmpty() && index.getFirst() < i - k + 1){
                index.removeFirst();
            }

            //if last element is lower than current nums[i], will not be needed
            while(!index.isEmpty() && nums[i] > nums[index.getLast()]){
                index.removeLast();
            }
            
            index.add(i);

            //if valid window, add last to res
            if(i >= k - 1){
                res.add(nums[index.getFirst()]);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}