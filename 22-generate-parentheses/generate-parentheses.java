class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        getAns(0, 0, ans, sb, n);

        return ans;
    }

    private void getAns(int open, int close, List<String> ans, StringBuilder sb, int n){

        if(open == close && close == n) ans.add(sb.toString());

        if(open < n){
            sb.append('(');
            getAns(open + 1, close, ans, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(open > close){
            sb.append(')');
            getAns(open, close + 1, ans, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}