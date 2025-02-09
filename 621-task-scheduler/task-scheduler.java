class Solution {
    public int leastInterval(char[] tasks, int n) {
        

        //maxHeap -> order tasks by freq descending
        //freq -> freq array
        //time -> time tracker
        //queue -> {freq, timeOut (time + n)}

        int[] freq = new int[26];

        //populate freq array 
        for(char c : tasks){

            freq[c - 'A']++;

        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int fre : freq){

            if(fre > 0) maxHeap.add(fre);
        }

        int time = 0;

        Queue<int[]> q = new LinkedList<>();

        while(!maxHeap.isEmpty() || !q.isEmpty()){

            time++;

            if(maxHeap.isEmpty()){

                time = q.peek()[1];
            }
            else{

                int newFre = maxHeap.poll() - 1;

                if(newFre > 0){

                    q.add(new int[]{newFre, time + n});

                }

            }

            if(!q.isEmpty() && time == q.peek()[1]){

                maxHeap.add(q.poll()[0]);
            }
        }

        return time;


    }
}