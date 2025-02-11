class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //Queue{Frequency, timeOut}, freq array, 

        //freq array 
        int[] freq = new int[26];

        for(int i = 0; i < tasks.length; i++){

            freq[tasks[i] - 'A']++; 

        }

        //maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int fre : freq){

            if(fre != 0) maxHeap.add(fre);
        }

        //queue{Freq, timeOut}
        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!q.isEmpty() || !maxHeap.isEmpty()){

            //if maxHeap is empty, skip to the time that the topmost tasks comes out of q
            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            }

            if(!maxHeap.isEmpty()){
                int task = maxHeap.poll();

                task = task - 1;

                if(task > 0){
                    q.add(new int[]{task, time + n});
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