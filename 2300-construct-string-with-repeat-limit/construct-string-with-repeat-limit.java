class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        //create a alphabet frequency array 
        int[] freq = new int[26];

        //populate it by subtracting 'a' from each char in given string 
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int index = 25;

        while(index >= 0){

            //start from the end, since lexicographically largest = bigger chars; and subtract if they dont exidt in original string
            if(freq[index] == 0){
                index--;
                continue;
            }

            //append biggest char used times, which is min bw freq and repeatLimit
            int used = Math.min(freq[index], repeatLimit);

            for(int k = 0; k < used; k++){
                sb.append((char)('a' + index));
            }

            //subtract used from that char's freq
            freq[index] -= used;
        
            //after appending, if there are chars left for that index, do this
            if(freq[index] > 0){

                //go to prevIndex
                int prevIndex = index - 1;

                //until it exists
                while(prevIndex >= 0 && freq[prevIndex] == 0){
                    prevIndex--;
                }

                //if it does not, break out and return
                if(prevIndex < 0){
                break; 
                } 

                //if it does, append chars and repeat loop
                sb.append((char)('a' + prevIndex));
                freq[prevIndex]--;
            }
        }

        return sb.toString();
    }
}