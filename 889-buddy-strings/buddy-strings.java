class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        //if len of s and goal are diff, return false
        if(s.length() != goal.length()) return false;

        //if both are equal, add to a hashset and if duplicate characters exist, true 
        if(s.equals(goal)){
            HashSet<Character> unique_chars = new HashSet<>();

            for(char c : s.toCharArray()){
                unique_chars.add(c);
            }

            if(unique_chars.size() < s.length()){
                return true;
            }
            else{
                return false;
            }
        }

        //create a list of indices where chars differ, if this list is != 2, return false
        List<Integer> diff = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                diff.add(i);
            }
        }

        if(diff.size() != 2) return false;

        //if the chars in each string at each index == one another, return true
        if(diff.size() == 2 && s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) && s.charAt(diff.get(1)) == goal.charAt(diff.get(0))){
            return true;
        }

        return false;
    }

}