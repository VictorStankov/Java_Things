package exceptions;

public class Demo {
    public static void main(String[] args){
        Person first = new Person("John", 5);
        Person second = null;

        first.compareAge(first, second);
        System.out.println(first.convertToText(6));
    }
}
