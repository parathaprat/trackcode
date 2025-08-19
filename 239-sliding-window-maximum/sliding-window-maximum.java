class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //use a montonic queue
        //index -> q, result -> arrayList
        //front of the q stores max index
        //removeFirst if out of window
        //removeLast if greater element appears

        LinkedList<Integer> index = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            //keep removing front when outside the window
            while(!index.isEmpty() && index.getFirst() < i - k + 1){
                index.removeFirst();
            }

            //keep removing back when nums[i]>
            while(!index.isEmpty() && nums[i] > nums[index.getLast()]){
                index.removeLast();
            }

            index.add(i);

            //if window is satisfied, pop front to res
            if(i >= k - 1){
                res.add(nums[index.getFirst()]);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}