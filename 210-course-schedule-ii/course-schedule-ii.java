class Solution {

    Set<Integer> visit = new HashSet<>();
    Set<Integer> pros = new HashSet<>();
    List<Integer> res = new LinkedList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){

            if(!dfs(i)) return new int[0];
        }

        int[] ans = new int[res.size()];
        
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }

    private boolean dfs(int course){

        if(pros.contains(course)) return true;
        if(visit.contains(course)) return false;
        
        visit.add(course);

        for(int nei : map.get(course)){
            if(!dfs(nei)) return false;
        }

        res.add(course);
        pros.add(course);
        visit.remove(course);
        return true;
    }
}