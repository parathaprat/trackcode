
class Pair { 
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {

    //start by creating adj map using adj list
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();

    //maintain a visited set
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //using DFS to detect cycles

        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        //for each prereq, add req course for each course into the map
        for(int[] prereq : prerequisites){

            preMap.get(prereq[0]).add(prereq[1]);

        }

        //cycle through courses, run dfs and if any returns false, return false
        for(int i = 0; i < numCourses; i++){

            if(!dfs(i)){
                return false;
            }

        }
        return true;
    }

    public boolean dfs(int course){

        //check if course is visited along dfs path, if it is return false
        if(visited.contains(course)) return false;

        //check if preMap contains any prereqs, if its empty, return true
        if(preMap.get(course).isEmpty()) return true;

        //add course to visited and cisit each of its prereqs
        visited.add(course);

        for(int pre : preMap.get(course)){

            if(!dfs(pre)) return false;

        }

        //backtracking
        visited.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}