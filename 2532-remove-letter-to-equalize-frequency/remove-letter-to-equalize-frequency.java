class Solution {
    public boolean equalFrequency(String word) {

        int[] freq = new int[26];

        for(char c : word.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : word.toCharArray()){
            freq[c - 'a']--;
            if(check(freq)) return true;
            freq[c - 'a']++;
        }

        return false;
    }

    private boolean check(int[] freq){

        int f = 0;

        for(int fr : freq){

            if(fr == 0) continue;
            if(f == 0) f = fr;
            if(fr == f) continue;
            else return false;
        }

        return true;
    }
}