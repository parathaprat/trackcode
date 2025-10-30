class Solution {

    Set<Integer> visit = new HashSet<>();
    Set<Integer> pros = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();

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

    public boolean dfs(int course){

        if(visit.contains(course)) return false;
        if(pros.contains(course)) return true;

        visit.add(course);

        for(int nei : map.get(course)){
            if(!dfs(nei)) return false;
        }

        visit.remove(course);
        pros.add(course);
        res.add(course);
        return true;
    }
}