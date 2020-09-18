public class List {
    private Node head;
    private Node current;
    private int size;

    public void add(Node node) {
        if (size == 0) {
            head = node;
            current = node;
            size++;
        } else {
            current.setNext(node);
            node.setNext(head);
            current = current.getNext();
            size++;
        }
    }

    public void delete() {
        if (current.getNext() == head) {
            current.setNext(head.getNext());
            head = current.getNext();
            size--;
        } else {
            current.setNext(current.getNext().getNext());
            size--;
        }
    }

    public void reset() {
        current = head;
    }

    public List() {
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getCurrent() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
