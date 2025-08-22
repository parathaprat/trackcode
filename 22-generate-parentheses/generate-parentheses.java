class Solution {
    public List<String> generateParenthesis(int n) {
        
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        backtrack(0, 0, sb, ans, n);
        return ans;
    }

    private void backtrack(int open, int close, StringBuilder sb, List<String> ans, int n){

        if(open == close && close == n){
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backtrack(open + 1, close, sb, ans, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(open > close){
            sb.append(')');
            backtrack(open, close + 1, sb, ans, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}