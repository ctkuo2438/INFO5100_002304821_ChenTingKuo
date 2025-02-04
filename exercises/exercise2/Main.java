package exercises2;

public class Main {
    public static void main(String[] args) {
        // create a c object with radius = 5
        Circle c = new Circle(5);
        Triangle t = new Triangle(6, 4, 5, 5);
        Rectangle r = new Rectangle(6, 8);
        Square s = new Square(6);

        // Circle method
        System.out.println("Shape Name:" + c.name);
        System.out.println("Area:" + c.calculateArea());
        System.out.println("Perimeter:" + c.calculatePerimeter());
        c.displayColor();

        // Triangle method
        System.out.println("Shape Name:" + t.name);
        System.out.println("Area:" + t.calculateArea());
        System.out.println("Perimeter:" + t.calculatePerimeter());
        t.displayColor();

        // Rectangle method
        System.out.println("Shape Name:" + r.name);
        System.out.println("Area:" + r.calculateArea());
        System.out.println("Perimeter:" + r.calculatePerimeter());
        r.displayColor();

        // Square method
        System.out.println("Shape Name:" + s.name);
        System.out.println("Area:" + s.calculateArea());
        System.out.println("Perimeter:" + s.calculatePerimeter());
        s.displayColor();

    }
}
