class Solution {
    public void nextPermutation(int[] nums) {

        // [1, 2, 3, 5, 4, 2];
        // [1, 2, 4, 5, 3, 2];
        // [1, 2, 4, 2, 3, 5]

        //find pivot -> find the first decreasing element from the right
        //if pivot not found, return reverse of nums
        //swap with the first element > pivot on the right
        //swap right of pivot

        int pivot = -1;
        int n = nums.length;

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                pivot = i;
                break;
            }
        }

        if(pivot == -1){
            reverse(nums, 0, n - 1);
            return;
        }

        //find the smallest number greater than pivot in the right half
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] > nums[pivot]){
                swap(nums, pivot, i);
                break;
            }
        }

        //reverse the half after pivot
        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}