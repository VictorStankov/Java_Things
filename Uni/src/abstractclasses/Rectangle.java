package abstractclasses;

public class Rectangle extends Polygon{
    private double a, b;

    public Rectangle(double a, double b){
        super(4);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double calcPerimeter(){
        return 2 * a + 2 * b;
    }

    @Override
    public double calcArea(){
        return a * b;
    }
}
