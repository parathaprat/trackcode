class Solution {
    public String minWindow(String s, String t) {

        int left = 0;
        int right = 0;

        int resLen = Integer.MAX_VALUE;
        int[] res = new int[2];

        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int need = countT.size();
        int have = 0;

        while(right < s.length()){

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && countT.get(c).equals(window.get(c))) have++;

            while(have == need){

                if(resLen > right - left + 1){
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftc = s.charAt(left);
                window.put(leftc, window.get(leftc) - 1);

                if(countT.containsKey(leftc) && countT.get(leftc) > window.get(leftc)) have--;

                left++;
            }

            right++;
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}