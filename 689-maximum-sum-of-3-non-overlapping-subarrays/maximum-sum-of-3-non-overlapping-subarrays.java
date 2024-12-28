class Solution {

    int[] prefixSum;
    int[][] mem;
 
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        mem = new int[n][3];

        //fill mem array with -1
        for(int[] row : mem) Arrays.fill(row, -1);

        prefixSum = new int[n + 1];

        //filling prefix sum table
        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        //finding max sum for condition
        findMaxSum(nums, 0, 0, k);

        List<Integer> path = new ArrayList<>();

        //finding start indices for max sum value 
        findMaxSumPath(nums, 0, 0, k, path);

        return path.stream().mapToInt(i -> i).toArray();
    }

    int findMaxSum(int[] nums, int pos, int count, int k){

        //base. if count above 3, if subarrays no not possible; return 0// reference mem array
        if(count == 3) return 0;
        if(pos > nums.length - k) return 0;
        if(mem[pos][count] != -1) return mem[pos][count];

        //not starting subarray from current element -> pos + 1
        int dontStart = findMaxSum(nums, pos + 1, count, k);

        //starting subarray from current element -> pos + k, count + 1, use prefixSum array to calculate sum of included subarray of length k
        int startHere = findMaxSum(nums, pos + k, count + 1, k) + prefixSum[pos + k] - prefixSum[pos];

        //return max possible sum for that particular [pos][count];
        return mem[pos][count] = Math.max(dontStart, startHere);
    }

    void findMaxSumPath(int[] nums, int pos, int count, int k, List<Integer> path){

        //base
        if(count == 3) return;
        if(pos > nums.length - k) return;

        //not starting from current element
        int dontStart = findMaxSum(nums, pos + 1, count, k);

        //starting from current element 
        int startHere = findMaxSum(nums, pos + k, count + 1, k) + prefixSum[pos + k] - prefixSum[pos];

        //calling func recursively on optimal path
        if(startHere >= dontStart){
            path.add(pos);
            findMaxSumPath(nums, pos + k, count + 1, k, path);
        }
        else{
            findMaxSumPath(nums, pos + 1, count, k, path);
        }
    }
}