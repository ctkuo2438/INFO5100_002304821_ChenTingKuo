package exercises2;
// subclass Circle
public class Circle extends shape {
    // instance fields
    private double radius;

    // constructor
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    // Override calculateArea method, calculating the circle area
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Override calculatePerimeter method, calculating the circle perimeter
    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
