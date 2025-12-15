class Solution {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int[] freq = new int[26];

        for(char c : tasks){
            freq[c - 'A']++;
        }

        for(int fre : freq){
            if(fre != 0) pq.add(fre);
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!q.isEmpty() || !pq.isEmpty()){

            if(pq.isEmpty()){
                time = q.peek()[1];
            }
            if(!pq.isEmpty()){
                int task = pq.poll();
                task -= 1;
                if(task > 0) q.add(new int[]{task, time + n});
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }

            time++;
        }

        return time;
    }
}