class Solution {
    public List<String> generateParenthesis(int n) {
        
        // if open == close == n, return
        //open < n -> open
        //open > close -> close

        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        getAns(0, 0, ans, n, sb);

        return ans;
    }

    private void getAns(int open, int close, List<String> ans, int n, StringBuilder sb){

        if(open == close && close == n){
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            getAns(open + 1, close, ans, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(open > close){
            sb.append(')');
            getAns(open, close + 1, ans, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}