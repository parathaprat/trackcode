class Solution {
    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        backtrack(0, 0, sb, res, n);

        return res;
    }

    private void backtrack(int open, int close, StringBuilder sb, List<String> res, int n){

        if(open == close && close == n){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backtrack(open + 1, close, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(open > close){
            sb.append(')');
            backtrack(open, close + 1, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}