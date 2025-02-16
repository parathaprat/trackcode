class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //de-q approach
        LinkedList<Integer> index = new LinkedList<>();

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            //while index of the front of the dq is outside the window, remove
            while(!index.isEmpty() && index.getFirst() <= i - k){
                index.removeFirst();
            }

            //while the current num is >= rigthmost element in dq popRight
            //since we are maintaining a strickly decreasing dq
            while(!index.isEmpty() && nums[i] >= nums[index.getLast()]){
                index.removeLast();
            }

            //add index
            index.add(i);

            //start recording maximum only when the first full window is formed
            if(i >= k - 1){
                result.add(nums[index.getFirst()]);
            }
        }

        int[] ans = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            ans[i] = result.get(i);
        }

        return ans;

    }
}