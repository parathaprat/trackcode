class Solution {
    public String rankTeams(String[] votes) {

        //map -> rows: Teams, cols:Votes per position, last col -> Order

        int len = votes[0].length();
        int[][] map = new int[26][len + 1];

        //fill last row with rank
        for(int i = 0; i < 26; i++) map[i][len] = i;

        //populate map with votes
        for(int i = 0; i < votes.length; i++){

            String s = votes[i];

            for(int j = 0; j < len; j++){
                map[s.charAt(j) - 'A'][j]++;
            }
        }

        //comparator to sort teams in descending order
        Arrays.sort(map, (a, b) -> {
            
            for(int i = 0; i < len; i++){
                if(a[i] < b[i]) return 1;
                if(a[i] > b[i]) return -1;
            }
            return 0;
        });

        //convert ranking to string using the last col
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){
            sb.append((char)('A' + map[i][len]));
        }

        return sb.toString();
    }
}