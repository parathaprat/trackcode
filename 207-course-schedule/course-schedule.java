class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //detect loop in graph

        //adj map, visited

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

        if(visited.contains(course)) return false;

        visited.add(course);

        for(int pre : map.get(course)){

            if(!dfs(pre)) return false;

        }

        visited.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}