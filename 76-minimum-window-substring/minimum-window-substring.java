class Solution {
    public String minWindow(String s, String t) {
        
        //sliding window problem

        int left = 0;

        //maps -> count, window
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();

        //res stores indices of substring, resLen stores min len
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        //comparing window freq map with countT freq map
        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && countT.get(c).equals(window.get(c))) have++;

            //whenever condition is met, we reduce the window from the left
            while(have == need){

                if(right - left + 1 < resLen){
                    res[0] = left;
                    res[1] = right;
                    resLen = right - left + 1;
                }

                //reducing window
                char leftc = s.charAt(left);
                window.put(leftc, window.getOrDefault(leftc, 0) - 1);

                //update have based on reduced window
                if(countT.containsKey(leftc) && countT.get(leftc) > window.get(leftc)) have--;

                left++;
            }
        }

        return resLen == Integer.MAX_VALUE? "" : s.substring(res[0], res[1] + 1);
    }
}