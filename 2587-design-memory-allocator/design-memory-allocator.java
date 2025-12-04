class Allocator {

    int[] array;

    public Allocator(int n) {

        array = new int[n];

        for(int i = 0; i < array.length; i++){
            array[i] = -1;
        }
        
    }
    
    public int allocate(int size, int mID) {

        if(size > array.length) return -1;

        int count = 0;
        int startIndex = 0;
        int endIndex = 0;

        for(int i = 0; i < array.length; i++){

            if(array[i] == -1) count++;
            else{
                count = 0;
                startIndex = i + 1;
            }

            if(count == size){
                endIndex = i;
                break;
    
            }
        }

        if(startIndex > endIndex) return -1;

        Arrays.fill(array, startIndex, Math.min(endIndex + 1, array.length), mID);
        return startIndex;
        
    }
    
    public int freeMemory(int mID) {

        int count = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == mID){
                count++;
                array[i] = -1;
            }
        }

        return count;
        
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */