class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        //create a window of len = p.len
        //move thru, create int array, create string key
        //if key matches return index start of sliding window

        List<Integer> result = new ArrayList<>();

        int slide = p.length();

        for(int i = 0; i <= s.length() - p.length(); i++){

            int[] winFreq = new int[26];
            int[] pFreq = new int[26];

            for(int j = i; j < i + p.length(); j++){

                winFreq[s.charAt(j) - 'a']++;
                pFreq[p.charAt(j - i) - 'a']++;
                
            }

            if(Arrays.equals(winFreq, pFreq)) result.add(i);
        }

        return result;
    }
}