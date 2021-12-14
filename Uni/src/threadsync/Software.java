package threadsync;


import java.util.LinkedList;
import java.util.Queue;

public class Software {
    private Queue<String> requirements = new LinkedList<>();
    private Queue<String> code = new LinkedList<>();
    private Queue<String> done = new LinkedList<>();
    private Queue<String> fail = new LinkedList<>();
    private Queue<String> pass = new LinkedList<>();

    public Software() {
    }

    public Queue<String> getRequirements() {
        return requirements;
    }

    public Queue<String> getCode() {
        return code;
    }

    public Queue<String> getDone() {
        return done;
    }

    public Queue<String> getFail() {
        return fail;
    }

    public Queue<String> getPass() {
        return pass;
    }
}
