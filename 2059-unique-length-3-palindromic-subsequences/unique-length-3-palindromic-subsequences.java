class Solution {
    public int countPalindromicSubsequence(String s) {
        
        //right side array
        int[] R = new int[26];

        //populate w frequency for each char
        for(char u : s.toCharArray()) {
            R[u - 'a']++;
        }

        //left side array
        int[] L = new int[26];

        //result set -> set used to prevent duplicates
        HashSet<Integer> S = new HashSet<>();

        //iterate through s, decrement from R, increment L
        for(int i = 0; i < s.length(); i++){

            int t = s.charAt(i) - 'a';

            R[t]--;

            //iterate through all alphabets, if an alphabet exists in both left and right, valid palindrome can be formed.
            for(int j = 0; j < 26; j++){

                if(L[j] > 0 && R[j] > 0) {

                    //add unique encoding of t and j to set 
                    S.add(26 * t + j);
                }
            }

            L[t]++;

        }

        return S.size();
    }
}