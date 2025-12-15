class Solution {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); //CPU sim, highest freq first

        Queue<int[]> q = new LinkedList<>(); //cooldown q (task, time executable)

        int[] freq = new int[26];

        for(char c : tasks){
            freq[c - 'A']++;
        }
        
        for(int fre : freq){
            if(fre != 0) pq.add(fre);
        }

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

            if(!q.isEmpty() && time == q.peek()[1]){
                pq.add(q.poll()[0]);
            }

            time++;
        }

        return time;
    }
}