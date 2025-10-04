class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)) return false;
        }

        return true;
    }

    private boolean dfs(int course){

        if(visit.contains(course)) return false;

        visit.add(course);

        for(int nei : map.get(course)){
            if(!dfs(nei)) return false;
        }

        visit.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}