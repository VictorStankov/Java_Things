package genericsdemo;

public class GenericsDemo {
    public static void main(String[] args)
    {
        MyGenericsClass g = new MyGenericsClass();

        g.setMyVar("Java");
        g.printValue();
    }
}

class MyGenericsClass<T>{
    private T myVar;

    void setMyVar(T i)
    {
        myVar = i;
    }

    void printValue()
    {
        System.out.println("The value of myVar is " + myVar);
    }
}

class MyGenericsClass2<T extends Number>{

}