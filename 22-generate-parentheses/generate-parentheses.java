class Solution {
    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        backtrack(sb, res, n, 0, 0);

        return res;
    }

    private void backtrack(StringBuilder sb, List<String> res, int n, int open, int close){

        if(open == n && close == n){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            backtrack(sb, res, n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(")");
            backtrack(sb, res, n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}