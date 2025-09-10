class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //maxHeap storing highest freq tasks
        //queue storing eack task and its exit times

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int[] freq = new int[26];

        for(char t : tasks){
            freq[t - 'A']++;
        }

        for(int fre : freq){
            if(fre != 0) maxHeap.offer(fre);
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!q.isEmpty() || !maxHeap.isEmpty()){

            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            }

            if(!maxHeap.isEmpty()){

                int task = maxHeap.poll();
                task-= 1;

                if(task > 0) q.add(new int[]{task, time + n});
            }

            if(!q.isEmpty() && q.peek()[1] == time){

                maxHeap.add(q.poll()[0]);
                
            }


            time++;
            
        }

        return time;
    }
}