class Solution {
    public int maxTwoEvents(int[][] events) {

        //PriorityQ to sort based on end times (increasing)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        //sort events array by start times (increasing)
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int prevMax = 0;
        int res = 0;

        for(int event[] : events){
            
            //find prevMax -> find an events in the pq such that its end time < current events start time
            while(!pq.isEmpty() && pq.peek()[1] < event[0]){

                //finding max value out of every event before current event
                prevMax = Math.max(prevMax, pq.peek()[2]);
                pq.poll();
            }

            //update res to maximum of prevMax + current event// previous res
            res = Math.max(res, prevMax + event[2]);

            pq.offer(event);
        }

        return res;

    }
}