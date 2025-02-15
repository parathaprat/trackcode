class RandomizedSet {

    //map stores -> {element, Index}
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {

        map = new HashMap<>();
        list = new ArrayList<>();
        
    }
    
    public boolean insert(int val) {

        if(map.containsKey(val)) return false;

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
        
    }
    
    public boolean remove(int val) {
        
        //move last element to the index of removed element
        //update position in map
        //remove from map 

        if(!map.containsKey(val)) return false;

        int index = map.get(val);

        list.set(index, list.get(list.size() - 1));

        map.put(list.get(index), index);

        list.remove(list.size() - 1);

        map.remove(val);

        return true;
    }
    
    public int getRandom() {

        Random rd = new Random();

        return list.get(rd.nextInt(list.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */