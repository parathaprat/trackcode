class Solution {
    public int minSteps(String s, String t) {

        //calculate freq of s and t
        //sum of dif in freq / 2

        int[] ss = new int[26];
        int[] tt = new int[26];

        int ans = 0;

        for(char c : s.toCharArray()){
            ss[c - 'a']++;
        }
        
        for(char c : t.toCharArray()){
            tt[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            ans += Math.abs(ss[i] - tt[i]);
        }

        return ans/2;
    }
}