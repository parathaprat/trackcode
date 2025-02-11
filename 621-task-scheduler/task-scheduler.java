class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //freq array
        //queue{freq, timeOut}
        //maxHeap -> to sort

        int[] freq = new int[26];

        for(int i = 0; i < tasks.length; i++){

            freq[tasks[i] - 'A']++;

        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int fre : freq){

            if(fre != 0) maxHeap.add(fre);
        }

        Queue<int[]> q = new LinkedList<>();

        //iterator
        int time = 0;

        while(!q.isEmpty() || !maxHeap.isEmpty()){

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

            if(!q.isEmpty() && q.peek()[1] == time){

                maxHeap.add(q.poll()[0]);
            }

            time++;
        }

        return time;
    }
}