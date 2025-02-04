package exercises2;

// abstract class, can not build instance directly
public abstract class shape {
    // static field, every shape use the same color
    static String color = "Blue";

    // instance field, every shape's name, ex: Circle, Rectangle, etc...
    String name;

    // constructor, initialize name
    public shape(String name) {
        this.name = name;
    }

    // abstract methods, for subclass to implement
    abstract double calculateArea();
    abstract  double calculatePerimeter();

    // regular method, displaying the color of shape
    public void displayColor() {
        System.out.println(name + "colo is: " + color);
    }







}
