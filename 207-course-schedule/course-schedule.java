class Solution {

    //declare map to store prereq and visited set
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //fill up preMap with empty lists (to ensure empty courses also have lists)
        for(int i = 0; i < numCourses; i++){

            preMap.put(i, new ArrayList<>());

        }

        //fill up preMap with prereqs
        for(int[] prereq : prerequisites){

            preMap.get(prereq[0]).add(prereq[1]);

        }

        //call dfs
        for(int i = 0 ; i < numCourses; i++){

            if(!dfs(i)) return false;
            
        }

        return true;
 
    }

    public boolean dfs(int course){

        //if course is visited, false
        if(visited.contains(course)) return false;

        //if course is in map with empty prereq, true
        if(preMap.get(course).isEmpty()) return true;

        //visited node and go through its prereqs
        visited.add(course);

        for(int prereq : preMap.get(course)){

            if(!dfs(prereq)) return false;

        };

        //backtrack and return
        visited.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}