public class List {
    private Node head;
    private Node current;

    public void add(Node node) {
        if (head == null) {
            head = node;
            current = head;
        } else {
            current.setNext(node);
            current = current.getNext();
        }
    }

    public void reset() {
        current = head;
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
}
