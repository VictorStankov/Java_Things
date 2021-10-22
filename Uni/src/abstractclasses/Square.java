package abstractclasses;

public class Square extends Polygon{
    private double a;

    public Square(double a){
        super(4);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double calcPerimeter(){
        return 4 * a;
    }

    @Override
    public double calcArea(){
        return a * a;
    }
}
