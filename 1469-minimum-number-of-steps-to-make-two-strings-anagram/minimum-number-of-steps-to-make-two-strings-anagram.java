class Solution {
    public int minSteps(String s, String t) {

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for(char c : s.toCharArray()){
            freqS[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            freqT[c - 'a']++;
        }

        int steps = 0;

        for(int i = 0; i < 26; i++){
            steps += Math.abs(freqS[i] - freqT[i]);
        }

        return steps/2;
        
    }
}