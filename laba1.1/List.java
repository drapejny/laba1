public class List {
    private Node head;
    private Node current;
    private int size;


    public List(int size) {
        this.size = size;
    }

    public void add(Node node) {
        if (node.getCof() != 0) {
            if (head == null) {
                head = node;
                current = head;
            } else {
                current.setNext(node);
                current = node;
            }
        }
    }

    public void print() {
        current = head;
        while (current != null){
            System.out.printf("%+d(x^%d)",current.getCof(),current.getSt());
            current = current.getNext();
        }

    }
    public void reset(){
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
