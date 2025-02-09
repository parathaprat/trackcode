class Solution {

    //pre req map
    //visited set
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    //set to show fully processed nodes
    Set<Integer> pros = new HashSet<>();

    List<Integer> finalAns = new ArrayList<>();


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++){

            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            
            map.get(pre[0]).add(pre[1]);
            
        }

        for(int i = 0; i < numCourses; i++){

            if(!dfs(i)){
                return new int[0];
            }
        }

        int[] result = new int[finalAns.size()];

        for(int i = 0; i < result.length; i++){

            result[i] = finalAns.get(i);
        }

        return result;
    }

    private boolean dfs(int course){

        if(set.contains(course)) return false;

        // if(pros.contains(course)) return true;
        if(pros.contains(course)) return true;

        set.add(course);

        for(int pre : map.get(course)){

            if(!dfs(pre)) return false;

        }

        set.remove(course);
        pros.add(course);
        finalAns.add(course);
        return true;
    }
}