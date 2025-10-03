class Solution {
    public String minWindow(String s, String t) {
        
        //sliding window problem

        int left = 0;

        //maps for t and window
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //populating t map
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0; 
        int need = countT.size();

        //res = indices of substring, resLen = minLen
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        //slide window and compare freqs
        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            //satisfactory condition for that char
            if(countT.containsKey(c) && countT.get(c).equals(window.get(c))) have++;

            //update minLen whenever condition met
            while(have == need){

                if(right - left + 1 < resLen){
                    res[0] = left;
                    res[1] = right;
                    resLen = right - left + 1;
                }

                //reduce window
                char leftc = s.charAt(left);
                window.put(leftc, window.getOrDefault(leftc, 0) - 1);

                if(countT.containsKey(leftc) && countT.get(leftc) > window.get(leftc)) have--;

                left++;
            }
        }

        return resLen == Integer.MAX_VALUE? "" : s.substring(res[0], res[1] + 1);


    }
}