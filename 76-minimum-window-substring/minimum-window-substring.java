class Solution {
    public String minWindow(String s, String t) {

        //sliding window while calculating frequencies and storing left and right ind

        int left = 0;

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();

        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            if(countT.containsKey(c) && countT.get(c).equals(window.get(c))) have++;

            while(have == need){

                if(right - left + 1 < resLen){
                    res[0] = left;
                    res[1] = right;
                    resLen = right - left + 1;
                }

                char leftc = s.charAt(left);
                window.put(leftc, window.getOrDefault(leftc, 0) - 1);

                if(countT.containsKey(leftc) && countT.get(leftc) > window.get(leftc
                )) have--;
                left++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);

        
    }
}