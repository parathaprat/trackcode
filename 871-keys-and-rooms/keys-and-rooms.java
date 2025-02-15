class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Set<Integer> visit = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        visit.add(0);
        q.add(0);

        while(!q.isEmpty()){

            int room = q.poll();

            for(int key : rooms.get(room)){

                if(!visit.contains(key)){
                    q.add(key);
                    visit.add(key);
                }
            }
        }

        return visit.size() == rooms.size();
    }
}