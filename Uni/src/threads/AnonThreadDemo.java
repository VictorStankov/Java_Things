package threads;

public class AnonThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 5; i <= 10; i++) {
                    sum += i;
                    System.out.println(this.getName() + ": " + sum);
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 10; i <= 15; i++) {
                    sum += i;
                    System.out.println(this.getName() + ": " + sum);
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 15; i <= 20; i++) {
                    sum += i;
                    System.out.println(this.getName() + ": " + sum);
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
        thread1.start();
        thread2.start();
    }
}
