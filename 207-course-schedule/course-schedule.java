class Solution {

    //make a prereq map
    Map<Integer, List<Integer>> map = new HashMap<>();
        
    //make a visited set
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++){

            map.put(i, new ArrayList<>());
    
        }

        for(int[] pre : prerequisites){

            map.get(pre[0]).add(pre[1]);
        }

        //go through each course and check for cycles

        for(int i = 0; i < numCourses; i++){

            if(!dfs(i)) return false;
        }

        return true;


    }

    private boolean dfs(int course){

        if(visited.contains(course)) return false;

        if(map.get(course).isEmpty()) return true;

        visited.add(course);

        for(int pre : map.get(course)){

            if(!dfs(pre)) return false;
        }

        visited.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}