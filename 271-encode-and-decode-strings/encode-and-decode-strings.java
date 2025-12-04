public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str.length() + "#" + str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        int i = 0;

        List<String> res = new ArrayList<>();

        while(i < s.length()){

            int j = i;
            while((s.charAt(j) != '#')){
                j++;
            }

            int len = Integer.parseInt(s.substring(i, j));
            j++;

            String str = s.substring(j, j + len);
            res.add(str);

            i = j + len;
        }

        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));