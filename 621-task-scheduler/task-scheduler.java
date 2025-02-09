class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //max heap, freq array, queue, time

        int[] freq = new int[26];

        for(char c : tasks){

            freq[c - 'A']++;

        }

        //descending priority queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int fre : freq){

            if(fre > 0) maxHeap.add(fre);

        }

        int time = 0;

        //queue -> {freq, timeOut (time + n)}
        Queue<int[]> q = new LinkedList<>();
        
        while(!maxHeap.isEmpty() || !q.isEmpty()){

            time++;

            //case -> heap is empty
            if(maxHeap.isEmpty()){
                
                time = q.peek()[1];

            }

            //heap is not empty
            else{

                //get top task, reduce, add to queue IF > 0
                int newFre = maxHeap.poll() - 1;

                if(newFre > 0){

                    q.add(new int[]{newFre, time + n});
                }

            }

            //if the time for a task to come out is here, add it back to heap
            if(!q.isEmpty() && time == q.peek()[1]){
                
                maxHeap.add(q.poll()[0]);
                
            }

        }

        return time;


        
    }
}