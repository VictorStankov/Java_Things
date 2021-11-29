package innerclasses;

public class Queue {
    private Node head;
    private Node tail;
    private int size;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void push(Integer value) {
        Node node = new Node(value);

        if (head == null){
            head = tail = node;
            size++;
            return;
        }

        tail.next = node;
        tail = node;
        size++;
    }

    public Integer pop() {
        if (size == 0)
            return null;

        Node node = head;
        head = head.next;
        size--;

        return node.value;
    }

    private class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }
}
