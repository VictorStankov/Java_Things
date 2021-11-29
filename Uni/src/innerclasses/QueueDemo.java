package innerclasses;

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(10);
        queue.push(5);
        queue.push(21);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
