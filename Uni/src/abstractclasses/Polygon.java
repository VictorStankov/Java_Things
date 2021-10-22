package abstractclasses;

public abstract class Polygon {
    protected int nSides;

    public Polygon(int nSides){
        this.nSides = nSides;
    }

    abstract double calcArea();
    abstract double calcPerimeter();
}
