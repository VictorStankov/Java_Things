package innerclasses;

public class StudentDemo {
    public static void main(String[] args) {
        class StudentGrade implements StudentTreatment{
            private String name;
            private int grade;

            public StudentGrade(String name, int grade) {
                this.name = name;
                this.grade = grade;
            }

            @Override
            public String momReaction() {
                if (this.grade >= 4)
                    return "Good job!";
                else
                    return "Don't worry, you'll do fine on the next exam.";
            }

            @Override
            public String dadReaction() {
                if (this.grade >= 4)
                    return "Well done, kid!";
                else
                    return "You're not my son anymore.";
            }
        }

        StudentGrade student1 = new StudentGrade("John", 2);
        System.out.println("Mom: " + student1.momReaction() + "\nDad: " + student1.dadReaction());

        StudentGrade student2 = new StudentGrade("Mike", 6);
        System.out.println("Mom: " + student2.momReaction() + "\nDad: " + student2.dadReaction());
    }
}
