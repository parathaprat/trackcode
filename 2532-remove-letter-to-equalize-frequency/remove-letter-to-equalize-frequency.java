class Solution {
    public boolean equalFrequency(String word) {

        int[] freq = new int[26];

        for(char c : word.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : word.toCharArray()){
            freq[c - 'a']--;

            if(checkFreq(freq)) return true;

            freq[c - 'a']++;
        }

        return false;
        
    }

    private boolean checkFreq(int[] freq){

        int f = 0;

        for(int fr : freq){

            if(fr == 0) continue;
            else if(f == 0) f = fr;
            else if(f == fr) continue;
            else return false;
        }

        return true;
    }
}