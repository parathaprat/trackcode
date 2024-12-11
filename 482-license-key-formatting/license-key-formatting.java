class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        //make everything uppercase & remove all dashes
        s = s.toUpperCase();
        s = s.replaceAll("-", "");

        StringBuilder sb = new StringBuilder(s);

        //iterate k positions from the back and insert dashes
        for(int i = s.length() - k; i >0; i = i - k){
            
            sb.insert(i, "-");

        }

        return sb.toString();
    }
}