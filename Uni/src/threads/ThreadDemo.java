package threads;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread(5, 10);
        MyThread thread1 = new MyThread(10, 15);
        MyThread thread2 = new MyThread(15, 20);

        thread.start();
        thread1.start();
        thread2.start();
    }
}
