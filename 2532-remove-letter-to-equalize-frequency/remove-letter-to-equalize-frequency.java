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

        int fr = 0;

        for(int num : freq){

            if(num == 0) continue;
            if(fr == 0) fr = num;
            if(fr == num) continue;
            else return false;

        }

        return true;
    }
}