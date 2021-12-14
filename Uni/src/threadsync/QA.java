package threadsync;

import java.util.Random;

public class QA extends Thread {
    private Software software;
    private Random random = new Random();

    public QA(Software software) {
        this.software = software;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (software.getDone()) {
                if (software.getDone().peek() != null) {
                    System.out.println("QA took " + software.getDone().peek() + " to test.");

                    try {
                        this.join(random.nextLong(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (random.nextBoolean()) {
                        System.out.println("QA added " + software.getDone().peek() + " for editing.");
                        software.getFail().add(software.getDone().poll());
                    } else {
                        System.out.println("QA added " + software.getDone().peek() + " for verification.");
                        software.getPass().add(software.getDone().poll());
                    }

                    try {
                        this.join(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
