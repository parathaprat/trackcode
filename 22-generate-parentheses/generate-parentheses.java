class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        getAns(0, 0, n, res, sb);

        return res;
    }

    private void getAns(int open, int close, int n, List<String> res, StringBuilder sb){

        //if(open == close == n)
        //if(open < n) open
        //if(open > close) close

        if(open == close && close == n){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            getAns(open + 1, close, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(open > close){
            sb.append(')');
            getAns(open, close + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}