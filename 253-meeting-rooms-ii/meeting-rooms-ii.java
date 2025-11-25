class Solution {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //pq of meeting end time
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