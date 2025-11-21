class Solution {

    //form valid words in cur list recrusively
    //use sb to concatenate, and add to list when wne do the string is reached

    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        helper(0, set, res, cur, s);

        return res;
    }

    private void helper(int ind, Set<String> set, List<String> res, List<String> cur, String s){

        if(ind >= s.length()){

            if(cur.size() != 0){

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
                helper(i + 1, set, res, cur, s);
                cur.remove(cur.size() - 1);
            }
        }
    }
}