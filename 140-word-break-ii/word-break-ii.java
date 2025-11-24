class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        List<String> cur = new ArrayList<>();

        dfs(0, s, res, set, cur);

        return res;
    }

    public void dfs(int ind, String s, List<String> res, Set<String> set, List<String> cur){

        if(ind >= s.length()){

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < cur.size(); i++){
                if(i > 0) sb.append(" ");
                sb.append(cur.get(i));
            }

            res.add(sb.toString());
        }

        for(int i = ind; i < s.length(); i++){

            if(set.contains(s.substring(ind, i + 1))){
                cur.add(s.substring(ind, i + 1));
                dfs(i + 1, s, res, set, cur);
                cur.remove(cur.size() - 1);
            }
        }

        return;


    }
}