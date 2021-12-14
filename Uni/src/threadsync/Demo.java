package threadsync;

public class Demo {
    public static void main(String[] args) {
        Software software = new Software();
        BA ba = new BA(software);
        Dev dev = new Dev(software);
        QA qa = new QA(software);

        ba.start();
        dev.start();
        qa.start();

        try {
            ba.join();
            dev.join();
            qa.join();
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
