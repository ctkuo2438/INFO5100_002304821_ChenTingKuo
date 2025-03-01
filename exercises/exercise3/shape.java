package exercise3;
import java.io.Serializable;

public abstract class shape implements Serializable {
    static String color = "Blue";
    String name;

    public shape(String name) {
        this.name = name;
    }

    abstract double calculateArea();
    abstract double calculatePerimeter();

    public void displayColor() {
        System.out.println(name + " color is: " + color);
    }
}