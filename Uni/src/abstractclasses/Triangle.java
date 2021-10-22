package abstractclasses;

import java.lang.Math;

public class Triangle extends Polygon{
    private double a, b, c;

    public Triangle(double a, double b, double c){
        super(3);
        this.a = a;
        this.b = b;
        this.c = c;
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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double calcPerimeter(){
        return a + b + c;
    }

    @Override
    public double calcArea(){
        double halfPerimeter = calcPerimeter() / 2;
        return Math.pow(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c), 0.5);
    }
}
