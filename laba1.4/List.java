public class List {
    private Node head;
    private Node current;

    public void add(Node node) {
        if (head == null) {
            head = node;
            current = head;
        } else if (node.getNumber() < head.getNumber()) {
            node.setNext(head);
            head = node;
        } else {
            while (current.getNext() != null && node.getNumber() > current.getNext().getNumber())
                current = current.getNext();
            node.setNext(current.getNext());
            current.setNext(node);
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
