package exceptions;

public class Demo {
    public static void main(String[] args){
        Person first = new Person("John", 5);

        first.compareAge(first, null);
        System.out.println(first.convertToText(6));
    }
}
