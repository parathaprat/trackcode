class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            if(!smap.containsKey(s.charAt(i))){
                smap.put(s.charAt(i), i);
            }

            if(!tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i), i);
            }

            if(!smap.get(s.charAt(i)).equals(tmap.get(t.charAt(i)))) return false;
        }

        return true;
    }
}