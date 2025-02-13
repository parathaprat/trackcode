class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> pros = new HashSet<>();
    List<Integer> res = new ArrayList<>();


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //detect loop in graph

        //adj map, visited

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

        for(int i = 0; i < ans.length; i++){

            ans[i] = res.get(i);

        }

        return ans;

    }

    private boolean dfs(int course){

        if(visited.contains(course)) return false;

        if(pros.contains(course)) return true;

        visited.add(course);

        for(int pre : map.get(course)){

            if(!dfs(pre)) return false;

        }

        visited.remove(course);
        // map.put(course, new ArrayList<>());
        pros.add(course);
        res.add(course);
        return true;
    }
}