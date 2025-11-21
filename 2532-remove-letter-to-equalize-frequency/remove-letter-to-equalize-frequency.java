class Solution {
    public boolean equalFrequency(String word) {

        //get a freq array
        //reduce freq of each letter, check if all freq vals match

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
