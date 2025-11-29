class Solution {
    public int minMeetingRooms(int[][] intervals) {

        //pq with min end times to see if a room can be freed for next minMeetingRooms
        //sort intervals by start time

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] in : intervals){

            if(!pq.isEmpty() && in[0] >= pq.peek()){
                pq.poll();
            }

            pq.add(in[1]);

        }

        return pq.size();
        
    }
}