package exceptions;

import java.lang.Math;

public class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void compareAge(Person first, Person second){
        try {
            System.out.println((first.age > second.age) ? first.name : second.name);
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public String convertToText(double grade){
        if (grade < 2 || grade > 6)
            throw new IllegalArgumentException("Illegal Number!");

        String[] gradeText = {"two", "three", "four", "five", "six"};

        return gradeText[(int)Math.round(grade) - 2];
    }
}
