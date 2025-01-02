class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        //custom comparator 
        Arrays.sort(logs, (a, b) -> {

            //get index of the first spaces for each word, [identifier - space - log]
            int i = a.indexOf(" ");
            int j = b.indexOf(" ");

            //if both logs are digits, equal priority, return 0
            if(Character.isDigit(a.charAt(i + 1)) && Character.isDigit(b.charAt(j + 1))) return 0;

            //log a ia digit and log b is char; b , a
            if(Character.isDigit(a.charAt(i + 1))) return 1;

            //log b ia digit and log a is char; a , b
            if(Character.isDigit(b.charAt(j + 1))) return -1;

            // compare logs to order them lexicographically, if comparator is ==, compare identifiers
            int val = a.substring(i + 1).compareTo(b.substring(j + 1));

            if(val != 0){
                return val;
            }

            //comparing identifiers 
            return a.compareTo(b);
        });

        return logs;

    }
}