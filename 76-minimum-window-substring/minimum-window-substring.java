class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int need = countT.size();
        int have = 0;

        int left = 0;
        int right = 0;

        int[] res = new int[2];
        int resLen = Integer.MAX_VALUE;

        while(right < s.length()){

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))) have++;

            while(have == need){

                if(right - left + 1 < resLen){
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftc = s.charAt(left);
                window.put(leftc, window.get(leftc) - 1);
                left++;

                if(countT.containsKey(leftc) && countT.get(leftc) > window.get(leftc)) have--;
            }

            right++;
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
        
    }
}