class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        helper(s, 0, dict, res, cur);

        return res;
        
    }

    private void helper(String s, int i, Set<String> dict, List<String> res, List<String> cur){

        //if cur has a valid sentence
        if(i == s.length()){

            if(cur.size() > 0){

                //break it down using sb and append to res
                StringBuilder sb = new StringBuilder();

                for(int j = 0; j < cur.size(); j++){

                    if(j > 0) sb.append(' ');
                    sb.append(cur.get(j));
                }

                res.add(sb.toString());
            }

            return;
        }

        //if no target, check if dict has validsubstring, add to cur and call helper again, then backtrak
        for(int j = i; j <= s.length(); j++){

            if(dict.contains(s.substring(i, j))){

                cur.add(s.substring(i, j));
                helper(s, j, dict, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }


}