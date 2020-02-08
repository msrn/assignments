public class List {

    class Node {
        public Node prev;
        public Node next;
        public int data;

        public Node (int d) {
            this.data = d;
        }

        public void print() {
            System.out.print(data + ";");
        }
    }

    public Node head;
    public Node tail;
    private int size = 0;

    public void add(int data) {
        Node newNode = new Node(data);
        newNode.data = data;
        if (head==null) {
            head = newNode;
            tail = newNode;
            size++;
        }

        if (newNode.data <= head.data) { //insert as first
            addFirst(newNode);
        } else if (newNode.data >= tail.data) { //insert as last
            addLast(newNode);
        } else { // add before
            Node temp = head;
            while (newNode.data > temp.data) {
                temp = temp.next;
            }
            addBefore(newNode, temp);
        }
    }

    private void addFirst(Node newNode) {
        Node temp = head;
        head = newNode;
        head.next = temp;
        head.next.prev = head;
    }

    private void addLast(Node newNode) {
        Node temp = tail;
        tail = newNode;
        tail.prev = temp;
        tail.prev.next = tail;
    }

    private void addBefore(Node newNode, Node temp2) {
        Node temp = temp2.prev;
        temp2.prev = newNode;
        temp2.prev.prev = temp;
        temp2.prev.prev.next = temp.prev;
        temp2.prev.next = temp;
    }

    public void print() {
        if (head != null) {
            Node temp = head;
            temp.print();
            while (temp.next != null) {
                temp = temp.next;
                temp.print();
            }
        }
    }




}


