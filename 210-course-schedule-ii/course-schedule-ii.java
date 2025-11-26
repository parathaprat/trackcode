class Solution {

    Set<Integer> visit = new HashSet<>();
    Set<Integer> pros = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, res)) return new int[0];
        }

        int size = res.size();
        int[] ans = new int[size];

        for(int i = 0; i < size; i++){
            ans[i] = res.get(i);
        }

        return ans;
        
    }

    private boolean dfs(int course, List<Integer> res){

        if(visit.contains(course)) return false;
        if(pros.contains(course)) return true;

        visit.add(course);

        for(int nei : map.get(course)){

            if(!dfs(nei, res)) return false;
        }

        visit.remove(course);
        pros.add(course);
        res.add(course);
        return true;
    }
}