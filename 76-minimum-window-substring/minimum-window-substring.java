class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        int have = 0;
        int need = countT.size();

        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);
            
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(countT.containsKey(c) && countT.get(c).equals(window.get(c))) have++;
            

            while(have == need){

                if(right - left + 1 < resLen){
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftc = s.charAt(left);
                window.put(leftc, window.get(leftc) - 1);

                if(countT.containsKey(leftc) && countT.get(leftc) > window.get(leftc)) have--;
                left++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
        
    }
}