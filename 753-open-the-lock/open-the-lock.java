class Solution {
    public int openLock(String[] deadends, String target) {

        //Set -> deadends, Set -> visited combs
        //BFS with Q
        //add 0000 to q, explore unvisited combs that are not deadlocked

        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> vis = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        q.add("0000");
        vis.add("0000");

        int res = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                String cur = q.poll();

                if(set.contains(cur)) continue;

                if(cur.equals(target)) return res;

                for(int j = 0; j < cur.length(); j++){
                    
                    String up = goUp(cur, j);
                    String down = goDown(cur, j);

                    if(!vis.contains(up)){
                        q.add(up);
                        vis.add(up);
                    }

                    if(!vis.contains(down)){
                        q.add(down);
                        vis.add(down);
                    }
                }
            }

            res++;
        }

        return -1;
    }

    private String goUp(String cur, int j){

        char[] curArr = cur.toCharArray();

        if(curArr[j] == '9') curArr[j] = '0';
        else curArr[j]++;

        return new String(curArr);

    }

    private String goDown(String cur, int j){

        char[] curArr = cur.toCharArray();

        if(curArr[j] == '0') curArr[j] = '9';
        else curArr[j]--;

        return new String(curArr);

    }
}