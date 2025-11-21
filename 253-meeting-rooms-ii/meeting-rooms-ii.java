class Solution {
    public int minMeetingRooms(int[][] intervals) {

        //we want to reuse the room with the earliest end times
        //sort meetings by start times, create a min heap of end times
        //if ending <= start(next), pq.poll(), since room can be resused
        //add end times to meetings, return pq.size()

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] in : intervals){

            if(!pq.isEmpty() && pq.peek() <= in[0]){
                pq.poll();
            }

            pq.offer(in[1]);
        }

        return pq.size();
    }
}