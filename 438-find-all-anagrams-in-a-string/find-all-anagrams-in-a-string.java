class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        //create a window of len = p.len
        //move thru, create int array, create string key
        //if key matches return index start of sliding window

        //for sliding window, use pointers l, r; remove char(r) and add char(l)


        int l = 0; 
        int r = p.length() - 1;

        int[] pfreq = new int[26];
        int[] sfreq = new int[26];

        List<Integer> result = new ArrayList<>();

        //populate freq array for p
        for(char c : p.toCharArray()){

            pfreq[c - 'a']++;

        }

        while(r < s.length()){

            if(l == 0){
                for(int i = l; i <= r; i++){
                    
                    sfreq[s.charAt(i) - 'a']++;

                }

                l++;
                r++;
            }
            else{

                sfreq[s.charAt(l - 1) - 'a']--;
   
                sfreq[s.charAt(r) - 'a']++;

                l++;
                r++;
            }

            if(Arrays.equals(sfreq, pfreq)) result.add(l-1);
        }

        return result;

    }
}