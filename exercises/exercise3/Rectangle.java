package exercise3;
import java.io.Serializable;

public class Rectangle extends shape implements Serializable {
    private double height, width;

    public Rectangle(double height, double width) {
        super("Rectangle");
        this.height = height;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return height * width;
    }

    @Override
    double calculatePerimeter() {
        return (height * 2) + (width * 2);
    }
}
