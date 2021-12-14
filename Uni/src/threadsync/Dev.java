package threadsync;

import java.util.Random;

public class Dev extends Thread {
    private Software software;
    Random random = new Random();

    public Dev(Software software) {
        this.software = software;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (software.getFail()) {
                if (software.getFail().peek() != null) {
                    System.out.println("Dev added " + software.getFail().peek() + " for refactoring.");

                    try {
                        this.join(random.nextLong(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Dev added " + software.getFail().peek() + " for testing.");
                    software.getDone().add(software.getFail().poll());
                }
            }

            synchronized (software.getRequirements()) {
                if (software.getRequirements().peek() != null) {
                    System.out.println("Dev added " + software.getRequirements().peek() + " for implementation.");

                    try {
                        this.join(random.nextLong(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Dev added " + software.getRequirements().peek() + " for testing.");
                    software.getDone().add(software.getRequirements().poll());
                }
            }

            try {
                this.join(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
