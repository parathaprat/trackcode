class LRUCache {

    //DLL + Map implementation

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

    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {

        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {


        if(map.containsKey(key)){

            Node node = map.get(key);

            remove(node);
            insert(node);
           
            return node.val;

        }

        else{
            return -1;
        }
        
    }
    
    //if cap reached, evict tail.prev
    public void put(int key, int value) {

        //if that key exists, remove first and then add
        if(map.containsKey(key)){

            Node node = map.get(key);
            remove(node);

        }
        else if(map.size() == capacity){

            remove(tail.prev);

        }

        insert(new Node(key, value));
    }

    public void insert(Node node){

        map.put(node.key, node);

        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;

    }

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