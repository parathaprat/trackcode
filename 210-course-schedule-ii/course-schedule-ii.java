class Solution {

    //detect cycle in grpah using dfs -> II -> add a arraylist and processed set to store cycles

    //map {course, list(pre)}
    //visited set
    //pros set

    Map<Integer, List<Integer>> map = new HashMap <>();

    Set<Integer> visit = new HashSet<>();

    Set<Integer> pros = new HashSet<>();

    List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for(int i = 0; i < numCourses; i++){

            map.put(i, new ArrayList<>());
        }

        for(int pre[] : prerequisites){

            map.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){

            if(!dfs(i)) return new int[0];

        }

        int[] ans = new int[result.size()];

        for(int i = 0; i < ans.length; i++){

            ans[i] = result.get(i);
        }

        return ans;

    }

    private boolean dfs(int course){

        if(visit.contains(course)) return false;

        if(pros.contains(course)) return true;

        visit.add(course);

        for(int pre : map.get(course)){

            if(!dfs(pre)) return false;

        }

        visit.remove(course);
        pros.add(course);
        result.add(course);
        return true;

        
    }
}