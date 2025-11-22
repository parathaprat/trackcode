class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordDict);

        dfs(0, s, res, cur, set);

        return res;
        
    }

    private void dfs(int ind, String s, List<String> res, List<String> cur, HashSet<String> set){

        if(ind >= s.length()){

            if(cur.size() > 0){

                StringBuilder sb = new StringBuilder();

                for(int i = 0; i < cur.size(); i++){

                    if(i > 0) sb.append(" ");
                    sb.append(cur.get(i));

                }

                res.add(sb.toString());
            }
        }

        for(int i = ind; i < s.length(); i++){

            if(set.contains(s.substring(ind, i + 1))){
                cur.add(s.substring(ind, i + 1));
                dfs(i + 1, s, res, cur, set);
                cur.remove(cur.size() - 1);
            }
        }

        return;
    }
}