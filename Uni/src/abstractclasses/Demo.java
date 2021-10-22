package abstractclasses;

public class Demo {
    public static void main(String[] args){
        Square square = new Square(5);
        Rectangle rectangle = new Rectangle(6, 7);
        Triangle triangle = new Triangle(4, 5, 6);

        System.out.printf("Square Perimeter: %f\tArea: %f\n\n", square.calcPerimeter(), square.calcArea());
        System.out.printf("Rectangle Perimeter: %f\tArea: %f\n\n", rectangle.calcPerimeter(), rectangle.calcArea());
        System.out.printf("Triangle Perimeter: %f\tArea: %f\n", triangle.calcPerimeter(), triangle.calcArea());
    }
}
