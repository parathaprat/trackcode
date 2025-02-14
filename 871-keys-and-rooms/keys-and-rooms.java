class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        set.add(0);

        while(!q.isEmpty()){

            int level = q.size();

            for(int i = 0; i < level; i++){

                int room = q.poll();

                for(int key : rooms.get(room)){

                    if(!set.contains(key)){
                        set.add(key);
                        q.add(key);
                    }
                }
            }
        }

        return set.size() == rooms.size();
    }
}