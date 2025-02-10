class LRUCache {

    //approach -> DLL + HashMap ({key, node})

    class Node{

        int key;
        int val;

        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    //initialize head and tail
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    int capacity;

    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        
        this.capacity = capacity;

        //assign connections to head and tail
        head.next = tail;
        tail.prev = head;
    }
    
    //return val of node
    //return the val, remove the node, attach in the front
    public int get(int key) {

        if(map.containsKey(key)){

            Node node = map.get(key);

            remove(node);
            insert(node);

            return node.val;
        }

        return -1;
        
    }
    
    //if capacity != map.size(), Insert
    //if capacity full, remove tail.prev
    //if map alr contains key, remove and insert
    public void put(int key, int value) {
        
        Node node = new Node(key, value);

         //this condition should be checked first, since if existing key exists in a full cache, size remains same after insertion
        if(map.containsKey(key)){

            remove(map.get(key));
        }

        if(map.size() == capacity){

            remove(tail.prev);

        }

        insert(node);
    }

    public void remove(Node node){

        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public void insert(Node node){

        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

        map.put(node.key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */