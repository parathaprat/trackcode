class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        int sum = 0;
        int count = 0;

        //Create a set of banned numbers 
        Set<Integer> bannedNums = new HashSet<>();

        //add all banned numbers less than n
        for(int i = 0; i < banned.length; i++){ 
            if(1 <= banned[i] && banned[i] <= n){
                bannedNums.add(banned[i]);
            }
        }

        //iternate over n, skip banned nums
        for(int i = 1; i <= n; i++){

            if(bannedNums.contains(i)) continue;

            //check if sum + this iteration exceeds max
            if(sum + i > maxSum) break;

            //if not, add to sum and ++ count
            sum += i;
            count++;

        }

        return count;
    }
}