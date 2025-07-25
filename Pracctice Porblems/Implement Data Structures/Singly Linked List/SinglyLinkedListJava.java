// First we must create a node to populate our list
class Node {
    // Atributes
    int val;
    Node next;

    // Constructor   
    public Node(int new_val) {
        this.val = new_val;
        this.next = null;
        // this(new_val, null);
    }

    public Node(int new_val, Node next_node)
    {
        this.val = new_val;
        this.next = next_node;
        // this(new_val, next_node);
    }

}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        if (isEmpty()) 
            return -1;

        int iCur = 0;
        Node pCur = this.head;
        while (iCur < index && pCur != null) {
            iCur++;
            pCur = pCur.next;
        }
        if (pCur != null) {
            return pCur.val;
        } else {
            return -1;
        }
    }

    public void insertHead(int val) {
        Node new_head = new Node(val, this.head);
        this.head = new_head;
        if(this.head.next == null)
            this.tail = this.head;
    }

    public void insertTail(int val) {
        Node new_tail = new Node(val);
        if (this.tail == null) {
            this.head = new_tail;
            this.tail = new_tail;
        } else {
            this.tail.next = new_tail;
            this.tail = new_tail;
        }
    }

    public boolean remove(int index) {
        if (index == 0) {
            if (this.head == null) 
                return false;
            this.head = this.head.next;
            if (this.head == null) 
                this.tail = null;
            return true;
        }

        int iCur = 0;
        Node pCur = this.head;
        while (iCur < index - 1 && pCur != null) {
            iCur++;
            pCur = pCur.next;
        }

        // Remove the node ahead of curr
        if (pCur != null && pCur.next != null) {
            if (pCur.next == this.tail) {
                this.tail = pCur;
            }
            pCur.next = pCur.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Node pCur = this.head;
        while (pCur != null)
        {
            list.add(pCur.val);
            pCur = pCur.next;
        }
        return list;
    }

    public boolean isEmpty()
    {
        if(this.head == null)
            return true;
        return false;
    }
}