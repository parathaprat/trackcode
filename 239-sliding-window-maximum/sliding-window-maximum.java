class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //linkedlist monotonic queue strategy
        //maintain deque, add to result when window is size k
        //remove leftmost when outside window, remove rigthmost when nums[i] >

        List<Integer> index = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            //remove from the front when it goes outside the window 
            while(!index.isEmpty() && index.getFirst() < i - k + 1){
                index.removeFirst();
            }

            //remove from the end if new element is > (new will always get picked in the window)
            while(!index.isEmpty() && nums[i] > nums[index.getLast()]){
                index.removeLast();
            }

            //add valid index after all removals
            index.add(i);

            if(i >= k - 1){
                result.add(nums[index.getFirst()]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}