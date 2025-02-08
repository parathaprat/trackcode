class LRUCache {

    // main logic -> Doubly LL + HashMap (key, adress)

    //define node class
    //define head and tail nodes + capacity
    //define insert and delete functions
    class Node{

        Node prev, next;
        int key, value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Map< Integer, Node> map = new HashMap<>();
    int capacity;

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    //make head and tail point to each other; initialize LRU cache
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }
    
    //check if it exists in map, if it does, obtain node, remove and insert in DLL & return node.val
    public int get(int key) {
        
        if(map.containsKey(key)){

            Node node  = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    //if it already exists, remove before insert; if capacity is full, remove node before tail
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        if(map.size() == capacity){
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    //add to map, make connections
    public void insert(Node node){

        map.put(node.key, node);

        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        
    }

    //remove from map, adjust connections
    public void remove(Node node){

        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */