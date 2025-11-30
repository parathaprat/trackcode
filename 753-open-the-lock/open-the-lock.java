class Solution {
    public int openLock(String[] deadends, String target) {

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

        char[] curArr = cur.toCharArray();

        if(curArr[j] == '9') curArr[j] = '0';
        else curArr[j]++;

        return new String(curArr);
    }

    private String goDown(int j, String cur){

        char[] curArr = cur.toCharArray();

        if(curArr[j] == '0') curArr[j] = '9';
        else curArr[j]--;

        return new String(curArr);
    }
}