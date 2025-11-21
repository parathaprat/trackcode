class Solution {
    public int minMeetingRooms(int[][] intervals) {

        //we want to reuse the room with the earliest ending meeting;
        //sort array by start times
        //iterate through, store end times in a min heap
        //if end time of a meeting does not overlap, pop from pq
        //return size of pq

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //pq stores end times

        for(int[] in : intervals){

            if(!pq.isEmpty() && pq.peek() <= in[0]){
                pq.poll();
            }

            pq.offer(in[1]);

        }

        return pq.size();
    }
}