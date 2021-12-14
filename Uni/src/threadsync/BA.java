package threadsync;

public class BA extends Thread{
    private Software software;
    private int i = 1;

    public BA(Software software) {
        this.software = software;
    }

    @Override
    public void run() {
        while(true) {

            synchronized (software.getPass()) {
                if (software.getPass().peek() != null) {

                    System.out.println("BA added " + software.getPass().peek() + " in ready.");
                    software.getDone().add(software.getPass().poll());
                }
            }

            synchronized (software.getRequirements()) {
                if (software.getRequirements().size() < 5) {

                    System.out.println("BA added item" + i + " for development.");
                    software.getRequirements().add("item" + i++);
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
