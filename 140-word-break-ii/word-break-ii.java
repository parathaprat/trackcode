class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();
        List<String> cur =  new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);

        helper(0, res, cur, set, s);

        return res;
        
    }

    private void helper(int ind, List<String> res, List<String> cur, Set<String> set, String s){

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
                helper(i + 1, res, cur, set, s);
                cur.remove(cur.size() - 1);
            }
        }


    }
}