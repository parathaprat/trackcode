class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> set = new HashSet<>(Arrays.asList(deadends));

        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add("0000");
        vis.add("0000");

        int steps = 0;
        while(!q.isEmpty()){

            int level = q.size();

            for(int i = 0; i < level; i++){

                String cur = q.poll();
                if(cur.equals(target)) return steps;

                if(set.contains(cur)) continue;

                for(int j = 0; j < cur.length(); j++){

                    String up = goUp(j, cur);
                    String down = goDown(j, cur);

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

            steps++;
        }

        return -1;
    }

    private String goUp(int j, String s){

        char[] curArr = s.toCharArray();

        if(curArr[j] == '9') curArr[j] = '0';
        else curArr[j]++;

        return new String(curArr);
    }

    private String goDown(int j, String s){

        char[] curArr = s.toCharArray();

        if(curArr[j] == '0') curArr[j] = '9';
        else curArr[j]--;

        return new String(curArr);
    }
}