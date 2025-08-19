class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        LinkedList<Integer> index = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            while(!index.isEmpty() && index.getFirst() < i - k + 1){
                index.removeFirst();
            }

            while(!index.isEmpty() && nums[i] > nums[index.getLast()]){
                index.removeLast();
            }

            index.add(i);

            if(i >= k - 1){
                res.add(nums[index.getFirst()]);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}