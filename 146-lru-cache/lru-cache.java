class LRUCache {

    //Doubly Linked List

    class Node{

        Node next;
        Node prev;

        int key;
        int val;

        Node(int key, int val){

            this.key = key;
            this.val = val;

        }
    }

    //{Key, Node}
    Map<Integer, Node> map = new HashMap<>();

    int capacity;

    Node Head = new Node(0, 0);
    Node Tail = new Node(0, 0);

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        Head.next = Tail;
        Tail.prev = Head;

    }
    
    public int get(int key) {
        
        //if key exists, return its val
        //remove and insert node

        if(map.containsKey(key)){

            Node node = map.get(key);

            remove(node);
            insert(node);

            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {

        //if key exists, remove and add new
        //if does not, add after head
        //if capacity is full, remove tail.prev

        //first check if key exists -> capacity -> insert

        Node node = new Node(key, value);

        if(map.containsKey(key)){
            
            remove(map.get(key));

        }
        else if(map.size() == capacity){

            remove(Tail.prev);

        }

        insert(node);
        
    }

    //1 = 2 = 3
    public void remove(Node node){

        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }


    public void insert(Node node){

        map.put(node.key, node);

        node.next = Head.next;
        Head.next.prev = node;

        Head.next = node;
        node.prev = Head;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */