class RandomizedSet {

    private List<Integer> values; //main ds
    private Map<Integer, Integer> valuesIdx; //val -> index for o(1) ops

    public RandomizedSet() {
        this.values = new ArrayList<>();
        this.valuesIdx = new HashMap<>();
    }
    
    public boolean insert(int val) {

        if(valuesIdx.containsKey(val)) return false;

        valuesIdx.put(val, values.size());
        values.add(val);

        return true;
        
    }
    
    public boolean remove(int val) {

        //get index, put last element into index, remove element

        if(!valuesIdx.containsKey(val)) return false;

        int index = valuesIdx.get(val); //get index
        valuesIdx.put(values.get(values.size() - 1), index); //replace w last element
        valuesIdx.remove(val); //remove from map

        values.set(index, values.get(values.size() - 1)); //set last element to index in list
        values.remove(values.size() - 1); //remove last element;

        return true;

        
    }
    
    public int getRandom() {

        int index = (int)(Math.random() * values.size());
        return values.get(index);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */