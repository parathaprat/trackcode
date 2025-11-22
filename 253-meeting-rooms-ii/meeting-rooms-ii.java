class Solution {
    public int minMeetingRooms(int[][] intervals) {

        //sort by start times
        //min heap of end times to determine if room can be freed
        //return size of heap 

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] in : intervals){

            if(!pq.isEmpty() && pq.peek() <= in[0]) pq.poll();
            pq.add(in[1]);
        }

        return pq.size();
        
    }
}