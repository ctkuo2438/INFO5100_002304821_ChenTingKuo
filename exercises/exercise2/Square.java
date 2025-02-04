package exercises2;

public class Square extends shape {
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

