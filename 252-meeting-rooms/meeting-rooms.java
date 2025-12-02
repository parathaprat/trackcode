class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals.length == 0) return true;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] in : intervals){

            if(!pq.isEmpty() && pq.peek() <= in[0]){
                pq.poll();
            }

            pq.add(in[1]);
        }

        return pq.size() == 1;
        
    }
}