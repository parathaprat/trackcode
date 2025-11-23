class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        //map positions -> no of gaps
        //keep track of max, return rows - gaps

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(List<Integer> list : wall){
            
            int gaps = 0;

            for(int i = 0; i < list.size() - 1; i++){
                gaps += list.get(i);
                map.put(gaps, map.getOrDefault(gaps, 0) + 1);
                max = Math.max(max, map.get(gaps));
            }
        }

        return wall.size() - max;
        
    }
}