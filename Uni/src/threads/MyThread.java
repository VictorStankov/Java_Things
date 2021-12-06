package threads;

public class MyThread extends Thread{
    private int n, m;

    public MyThread(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i=n; i<=m; i++) {
            sum += i;
            System.out.println(this.getName() + ": " + sum);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
