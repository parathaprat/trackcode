class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //store freq, maxHeap, queue, time

        int[] freq = new int[26];

        for(char c : tasks){

            freq[c - 'A']++;

        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int fre : freq){
            if(fre > 0){
                maxHeap.add(fre);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;
        
        while(!maxHeap.isEmpty() || !q.isEmpty()){

            if(maxHeap.isEmpty()){

                time = q.peek()[1];

            }

            if(!maxHeap.isEmpty()){
                int task = maxHeap.poll();

                if(task - 1 > 0){
                    q.add(new int[]{task - 1, time + n});
                }
            }

            if(!q.isEmpty() && time == q.peek()[1]){
                maxHeap.add(q.poll()[0]);
            }

            time++;
        }

        return time;


    }
}