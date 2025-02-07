class Solution {
    public String minWindow(String s, String t) {

        if(t.isEmpty()) return "";
        
        //maintain countT and window maps
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){

            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        //have, need, res boundaries, resLen, l and r pointers
        int have = 0;
        int need = countT.size();

        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r = 0; r < s.length(); r++){

            //getting char and updating freq in window map
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            //have condition
            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))) have++;

            while(have == need){

                if(r - l + 1 < resLen){
                    //update res and resLen when have and need are equal and new resLen is less than old
                    res[0] = l;
                    res[1] = r;

                    resLen = r - l + 1;
                }

                //work on reducing window size from the left -> reduce from window, l++
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                //reduce have IF window count of char goes below countT count of char
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) have--;

                l++;
    
            }

        }

        return resLen == Integer.MAX_VALUE? "" : s.substring(res[0], res[1] + 1);

    }
}