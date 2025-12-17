class Solution {
    
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        dfs(res, list, 0, s);

        return res;
    }

    private void dfs(List<List<String>> res, List<String> list, int in, String s){

        if(in >= s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = in; i < s.length(); i++){

            if(isPalindrome(s, in, i)){
                list.add(s.substring(in, i + 1));
                dfs(res, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end){

        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}