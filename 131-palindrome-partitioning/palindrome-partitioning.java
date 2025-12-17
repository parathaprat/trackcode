class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        backtrack(res, list, 0, s);

        return res;
    }

    private void backtrack(List<List<String>> res, List<String> list, int in, String s){

        if(in >= s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = in; i < s.length(); i++){

            if(isPalindrome(s.substring(in, i + 1))){

                list.add(s.substring(in, i + 1));
                backtrack(res, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){

        int left = 0;
        int right = s.length() - 1;

        while(left < right){

            if(s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}