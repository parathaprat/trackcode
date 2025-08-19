class Solution {
    public String minWindow(String s, String t) {
        
        //sliding window problem
        //have, want, resLen, resArray
        //maps = countT, window

        if(t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};

        //populate countT
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();

        int left = 0;

        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && countT.get(c).equals(window.get(c))) have++;

            //if substring obtained, reduce from left until not satified to few newer substrings
            while(have == need){
                
                if(right - left + 1 < resLen){

                    res[0] = left;
                    res[1] = right;
                    resLen = right - left + 1;

                }

                char leftc = s.charAt(left);
                window.put(leftc, window.getOrDefault(leftc, 0) - 1);

                if(countT.containsKey(leftc) && countT.get(leftc) > window.get(leftc)) have--;

                left++;
            }
        }

        return resLen == Integer.MAX_VALUE? "" : s.substring(res[0], res[1] + 1);

    }
}