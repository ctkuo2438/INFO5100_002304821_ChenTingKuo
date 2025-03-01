package exercise3;
import java.io.Serializable;

public class Triangle extends shape implements Serializable {
    private double base, height, side1, side2;

    public Triangle(double base, double height, double side1, double side2) {
        super("Triangle");
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    double calculatePerimeter() {
        return base + side1 + side2;
    }
}

