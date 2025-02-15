class RandomizedSet {

    //we will use a map and a Arraylist to store our elements

    //{Node, Index in Array}
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {

        map = new HashMap<>();
        list = new ArrayList<>();

    }
    
    public boolean insert(int val) {

        //if map contains val, return false;
        if(map.containsKey(val)) return false;

        list.add(val);

        //add element and last index to map
        map.put(val, list.size() - 1); 

        return true;
        
    }
    
    public boolean remove(int val) {

        //if map does not contain val, return false;
        if(!map.containsKey(val)) return false;

        //if map contans val, remove
        //put last index of list to the position of the removed element

        //get index of element to remove
        int index = map.get(val);

        //move last element to the index 
        list.set(index, list.get(list.size() - 1));

        //update the change in the map
        map.put(list.get(index), index);

        //remove last element
        list.remove(list.size() - 1);

        //remove the val
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        
        Random rand = new Random();

        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */