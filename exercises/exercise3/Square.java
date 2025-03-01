package exercise3;
import java.io.Serializable;

public class Square extends shape implements Serializable {
    private double side;

    public Square(double side) {
        super("Square");
        this.side = side;
    }

    @Override
    double calculateArea() {
        return side * side;
    }

    @Override
    double calculatePerimeter() {
        return 4 * side;
    }
}
