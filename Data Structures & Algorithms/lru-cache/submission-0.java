class LRUCache {

    class Node {
        int key,value;
        Node next,prev;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        removeNode(node);
        insertAtHead(node); //move to MRU
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }
        Node newNode = new Node(key,value);
        map.put(key,newNode);
        insertAtHead(newNode);

        if(map.size()>capacity){
            Node lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }

    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

}
