class Solution {
    public int minSteps(String s, String t) {

        int steps = 0;

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            freq[c - 'a']--;
        }

        for(int num : freq){
            if(num < 0) num = -num;
            steps += num;
        }

        return steps/2;
        
    }
}