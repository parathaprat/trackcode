class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //HashMap {Task, Frequency} WRONG

        //Int freq array -> we dont need to deal with chars
        //maxHeap {Frequency}
        //Queue {Task, outTime}

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int[] freq = new int[26];

        for(char c : tasks){

            freq[c - 'A']++;
        }

        for(int fre : freq){

            if(fre != 0) maxHeap.add(fre);
        }

        //{freq, timeOut}
        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!q.isEmpty() || !maxHeap.isEmpty()){

            if(maxHeap.isEmpty()){

                time = q.peek()[1];

            }

            if(!maxHeap.isEmpty()){

                int task = maxHeap.poll();
                task -= 1;

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