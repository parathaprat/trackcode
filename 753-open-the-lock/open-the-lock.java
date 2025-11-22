class Solution {
    public int openLock(String[] deadends, String target) {

        //set for deadends
        //visited set
        //BFS

        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        Set<String> vis = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        q.add("0000");
        vis.add("0000");

        int num = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){

                String cur = q.poll();

                if(set.contains(cur)) continue;
                if(cur.equals(target)) return num;

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

            num++;
        }

        return -1; 
    }

    private String goUp(int j, String cur){

        char[] currArr = cur.toCharArray();

        if(currArr[j] == '9') currArr[j] = '0';
        else currArr[j]++;

        return new String(currArr);
    }

    private String goDown(int j, String cur){

        char[] currArr = cur.toCharArray();

        if(currArr[j] == '0') currArr[j] = '9';
        else currArr[j]--;

        return new String(currArr);
    }
}