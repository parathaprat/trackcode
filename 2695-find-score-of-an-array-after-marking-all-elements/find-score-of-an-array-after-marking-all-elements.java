class Solution {
    public long findScore(int[] nums) {
        
        //create a prioirty queue that will sort elements based on ascending order and if equal, indexes
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        //adding each element and its index to the pq
        for(int i = 0; i < nums.length; i++){
            pq.offer(new int[] {nums[i], i});
        }

        //hashset to mark indexes; score to keep track of score
        Set<Integer> set = new HashSet<>();
        long score = 0;

        //looping till pq has elements and till all elements are not marked
        while(!pq.isEmpty() && set.size() != nums.length){

            int[] top = pq.poll();

            //if index of top elemnt is already in set (marked), skip
            if(set.contains(top[1])) continue;

            //if unmarked add to score; mark adjecent elements if valid and return score
            score += top[0];

            if(top[1] - 1 >= 0){
                set.add(top[1] - 1);
            }

            if(top[1] + 1 < nums.length){
                set.add(top[1] + 1);
            }
        }

        return score;
    }
}